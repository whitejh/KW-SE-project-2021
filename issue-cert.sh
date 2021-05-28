#!/usr/bin/env bash
mkcert -install
mkcert -cert-file deployments/traefik/certs/local-cert.pem \
	--key-file deployments/traefik/certs/local-key.pem local.kw-se-2021.com
