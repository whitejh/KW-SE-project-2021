#!/bin/bash

psql -U postgres -d postgres -a </tmp/psql_data/schema.sql
psql -U postgres << EOSQL
	\copy member from /tmp/psql_data/dummy_data/dummy_member.csv delimiter ',' NULL as 'NULL' csv header;
	\copy goods from /tmp/psql_data/dummy_data/dummy_goods.csv delimiter ',' NULL as 'NULL' csv header;
	\copy goods_category from /tmp/psql_data/dummy_data/dummy_goods_category.csv delimiter ',' NULL as 'NULL' csv header;
	\copy bookmark from /tmp/psql_data/dummy_data/dummy_bookmark.csv delimiter ',' NULL as 'NULL' csv header;
	SELECT pg_catalog.setval(pg_get_serial_sequence('goods', 'id'), (SELECT MAX(id) FROM goods)+1);
	SELECT pg_catalog.setval(pg_get_serial_sequence('purchase_history', 'id'), (SELECT MAX(id) FROM purchase_history)+1);
	SELECT pg_catalog.setval(pg_get_serial_sequence('order_', 'id'), (SELECT MAX(id) FROM order_)+1);
EOSQL
