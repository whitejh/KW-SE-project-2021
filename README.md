# KW-SE-project-2021
광운대학교 소프트웨어공학 프로젝트 - 인터넷 쇼핑몰 웹 애플리케이션

# Deploy
모든 명령어는 repo root 경로에서 실행되는것을 가정한다.
1. `docker-compose -p kw up -d`로 db와 db_admin container를 배포
2. `docker exec -i kw_db_1 psql -U postgres -d postgres -a <src/db/schema.sql`로 본 프로젝트의 DB 스키마 반영
3. 스프링의 경우 구동하기 위해 kw-0.0.1-SNAPSHOT.jar와 같이 *.jar 파일이 필요함, 해당 파일을 /build/libs에 위치시켜야 함
4. reverse proxy, api, TODO...

# DB admin 접속하는법
Deploy의 docker-compose
1. http://localhost:8080 에 접속
2. team4@kw.ac.kr / kw123 으로 로그인
3. Dashboard -> Quick Link -> Add New Server 클릭
4. General -> Name 은 원하는걸로 (ex: kw)
5. Connection -> Host Name은 DB 컨테이너 이름 (여기서는 kw_db_1), Username은 postgres, Password는 kw123
6. kw -> databases -> postgres 마우스 오른쪽 클릭 -> Query Tool 선택

