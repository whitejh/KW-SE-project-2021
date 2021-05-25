from fastapi import FastAPI, Response, Request
from fastapi.responses import RedirectResponse
from requests_oauthlib import OAuth2Session
import jwt
import requests
from cryptography.x509 import load_pem_x509_certificate
import redis

import logging
import json
import time

app = FastAPI(root_path='/auth')

client_id = '301087377577-pkbv2clepgckgvuin4q011cond2973h6.apps.googleusercontent.com'
client_secret = 'c42bJ6JrONxT9mhZcDCRMgpl'
redirect_uri = 'https://local.kw-se-2021.com/auth/session'
scope = ['https://www.googleapis.com/auth/userinfo.email', 'https://www.googleapis.com/auth/userinfo.profile', 'openid']
oauth = OAuth2Session(client_id, redirect_uri=redirect_uri, scope=scope)

#TODO CSRF mitigation
authorization_url, state = oauth.authorization_url(
        'https://accounts.google.com/o/oauth2/auth',
        # access_type and prompt are Google specific extra
        # parameters.
        access_type="offline", prompt="select_account")

r = redis.Redis(host='kw_session_db_1', port=6379, db=0)

@app.get("/session")
def auth_session(request: Request):
    token = oauth.fetch_token(
        'https://accounts.google.com/o/oauth2/token',
        authorization_response=str(request.url),
        # Google specific extra parameter used for client
        # authentication
        client_secret=client_secret)

    header = jwt.get_unverified_header(token['id_token'])

    cert_str = requests.get('https://www.googleapis.com/oauth2/v1/certs').json()[header['kid']].encode()
    cert_obj = load_pem_x509_certificate(cert_str)
    pub_key = cert_obj.public_key()
    
    payload = jwt.decode(token['id_token'], pub_key, algorithms=['RS256'], audience=client_id)
    
    if payload['iat'] < time.time() < payload['exp']:
        if payload['email_verified']:
            r.set(payload['sub'], payload['email'])
            response = RedirectResponse('/main')
            response.set_cookie('kw_access_token', token['access_token'], max_age=token['expires_in'])
            response.set_cookie('kw_id_token', payload['sub'], max_age=token['expires_in'])
            return response
        else:
            raise jwt.PyJWTError('email_verified must be true')
    else:
        raise jwt.PyJWTError('this token is invalid at present')

@app.get("/")
def auth():
    return RedirectResponse(authorization_url)
