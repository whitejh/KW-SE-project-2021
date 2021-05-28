#!/usr/bin/env bash
mkcert -install
mkcert -cert-file deployments/gw/certs/local-cert.pem \
	--key-file deployments/gw/certs/local-key.pem local.kw-se-2021.com
