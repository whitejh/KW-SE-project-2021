#!/usr/bin/env bash

docker compose -p kw up -d --remove-orphans --build
docker exec -i kw_db_1 psql -U postgres -d postgres -a <src/db/schema.sql
docker exec -i kw_db_1 psql -U postgres -c "\copy goods from /var/lib/postgresql/dummydata/dummy_goods.csv delimiter ',' NULL as 'NULL' csv header;"