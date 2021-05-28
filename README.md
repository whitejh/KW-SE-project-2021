# KW-SE-project-2021

광운대학교 소프트웨어공학 프로젝트 - 인터넷 쇼핑몰 웹 애플리케이션

# Deploy - 개발/테스트
모든 명령어는 repo root 경로에서 실행되는것을 가정한다.

1. /etc/hosts에 `127.0.0.1 local.kw-se-2021.com` 추가
2. `mkcert -cert-file deployments/traefik/certs/local-cert.pem -key-file deployments/traefik/certs/local-key.pem "local.kw-se-2021.com"`
   로 인증서 발급
3. `./deploy.sh`로 배포
4. 스프링의 경우 구동하기 위해 kw-0.0.1-SNAPSHOT.jar와 같이 *.jar 파일이 필요함, 해당 파일을 /build/libs에 위치시켜야 함

# pgAdmin (postgres dbms admin) 접속

1. http://localhost:8080 에 접속
2. team4@kw.ac.kr / kw123 으로 로그인
3. Dashboard -> Quick Link -> Add New Server 클릭
4. General -> Name 은 원하는걸로 (ex: kw)
5. Connection -> Host Name은 DB 컨테이너 이름 (여기서는 kw_db_1), Username은 postgres, Password는 kw123
6. kw -> databases -> postgres 마우스 오른쪽 클릭 -> Query Tool 선택

# traefik (reverse proxy admin) 접속

1. https://local.kw-se-2021.com/dashboard 에 접속
2. HTTP Routers 에서 현재 어떤 경로들이 열려있는지 확인
2. HTTP Services 에서 현재 어떤 서비스들이 띄워져있는지 확
