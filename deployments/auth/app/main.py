import time

import jwt
import requests
from cryptography.x509 import load_pem_x509_certificate
from fastapi import FastAPI, Request
from fastapi.responses import RedirectResponse
from requests_oauthlib import OAuth2Session

from model import session, Member

app = FastAPI(root_path='/auth')

client_id = '301087377577-pkbv2clepgckgvuin4q011cond2973h6.apps.googleusercontent.com'
client_secret = 'c42bJ6JrONxT9mhZcDCRMgpl'
redirect_uri = 'https://local.kw-se-2021.com/auth/session'
scope = ['https://www.googleapis.com/auth/userinfo.email', 'https://www.googleapis.com/auth/userinfo.profile', 'openid']
oauth = OAuth2Session(client_id, redirect_uri=redirect_uri, scope=scope)

# TODO CSRF mitigation
authorization_url, state = oauth.authorization_url(
    'https://accounts.google.com/o/oauth2/auth',
    # access_type and prompt are Google specific extra
    # parameters.
    access_type="offline", prompt="select_account")


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

    if payload['iat'] - 60 < time.time() < payload['exp']:
        if payload['email_verified']:
            response = RedirectResponse('/shop/goods/#')

            id_ = payload['sub']

            user = session.query(Member).filter(Member.id == id_).first()

            if not user:
                session.add(Member(id=id_, email=payload['email']))
                session.commit()

            response.set_cookie('kw_id', id_, max_age=token['expires_in'])
            return response
        else:
            raise jwt.PyJWTError('email_verified must be true')
    else:
        raise jwt.PyJWTError(f'this token is invalid at present {payload["iat"]} < {time.time()} < {payload["exp"]}')


@app.get("/")
def auth():
    return RedirectResponse(authorization_url)
