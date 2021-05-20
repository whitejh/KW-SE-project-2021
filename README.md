# KW-SE-project-2021
광운대학교 소프트웨어공학 프로젝트 - 인터넷 쇼핑몰 웹 애플리케이션

# Deploy
모든 명령어는 repo root 경로에서 실행되는것을 가정한다.
1. `docker-compose -p kw up -d`로 db와 db_admin container를 배포
2. `docker exec -i kw_db_1 psql -U postgres -d postgres -a <src/db/schema.sql`로 본 프로젝트의 DB 스키마 반영
3. reverse proxy, api, TODO...
