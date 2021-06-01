FROM postgres:13

RUN mkdir -p /tmp/psql_data/

COPY schema.sql /tmp/psql_data/
COPY dummy_data /tmp/psql_data/dummy_data
COPY init.sh /docker-entrypoint-initdb.d/
