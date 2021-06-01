#!/bin/bash

psql -U postgres -d postgres -a </tmp/psql_data/schema.sql
psql -U postgres << EOSQL
	\copy member from /tmp/psql_data/dummy_data/dummy_member.csv delimiter ',' NULL as 'NULL' csv header;
	\copy goods from /tmp/psql_data/dummy_data/dummy_goods.csv delimiter ',' NULL as 'NULL' csv header;
	\copy goods_category from /tmp/psql_data/dummy_data/dummy_goods_category.csv delimiter ',' NULL as 'NULL' csv header;
	\copy bookmark from /tmp/psql_data/dummy_data/dummy_bookmark.csv delimiter ',' NULL as 'NULL' csv header;
EOSQL
