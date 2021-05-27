FROM tiangolo/uvicorn-gunicorn-fastapi:python3.7

RUN pip install --no-input requests_oauthlib pyjwt cryptography redis
COPY ./app /app
