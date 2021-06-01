#!/usr/bin/env bash

docker-compose -p kw up -d --remove-orphans --build
docker exec -i kw_db_1 psql -U postgres -d postgres -a <deployments/db/schema.sql
docker exec -i kw_db_1 psql -U postgres -c "\copy member from /var/lib/postgresql/dummydata/dummy_member.csv delimiter ',' NULL as 'NULL' csv header;"
docker exec -i kw_db_1 psql -U postgres -c "\copy goods from /var/lib/postgresql/dummydata/dummy_goods.csv delimiter ',' NULL as 'NULL' csv header;"
docker exec -i kw_db_1 psql -U postgres -c "\copy goods_category from /var/lib/postgresql/dummydata/dummy_goods_category.csv delimiter ',' NULL as 'NULL' csv header;"
docker exec -i kw_db_1 psql -U postgres -c "\copy bookmark from /var/lib/postgresql/dummydata/dummy_bookmark.csv delimiter ',' NULL as 'NULL' csv header;"
