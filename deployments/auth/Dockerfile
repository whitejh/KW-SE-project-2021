FROM tiangolo/uvicorn-gunicorn-fastapi:python3.7

RUN pip install --no-input requests_oauthlib
COPY ./app /app

# CMD ["uvicorn", "main:app", "--host", "local.kw-se-2021.com", "--port", "443", "--ssl-keyfile", "/etc/certs/local-key.pem", "--ssl-certfile", "/etc/certs/local-cert.pem"]
