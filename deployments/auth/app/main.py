from fastapi import FastAPI, Response, Request
from fastapi.middleware.httpsredirect import HTTPSRedirectMiddleware
from requests_oauthlib import OAuth2Session

import logging
import json

app = FastAPI()
#app.add_middleware(HTTPSRedirectMiddleware)


client_id = '301087377577-pkbv2clepgckgvuin4q011cond2973h6.apps.googleusercontent.com'
client_secret = 'c42bJ6JrONxT9mhZcDCRMgpl'
redirect_uri = 'https://local.kw-se-2021.com/_oauth'
scope = ['https://www.googleapis.com/auth/userinfo.email', 'https://www.googleapis.com/auth/userinfo.profile', 'openid']
oauth = OAuth2Session(client_id, redirect_uri=redirect_uri, scope=scope)

@app.get("/_oauth")
def read_root(response: Response, request: Request):
    return oauth.fetch_token(
        'https://accounts.google.com/o/oauth2/token',
        authorization_response=str(request.url),
        # Google specific extra parameter used for client
        # authentication
        client_secret=client_secret)

@app.get("/_oauth/callback")
def foo():
  return {"foo": "bar"}
