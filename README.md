# 오피스 허브
==================

2021.02 ~ 2021.07까지 진행된 프로젝트

1. VMware를 이용해서 (폐쇄망) 서버 구성(연동 확인 완료!)
-------------------------------------------------------

(1) DNS        
(2) WAS - OfficeHubServer-Boot      
(3) WebServer - OfficeHubWeb의 내용 게시      
(4) DB - MySQL 8     
(5) SMTP/POP     

2. 사용 기술 스택
------------------
OfficeHubServer-Boot

(1) Docker
 - 개발계를 AWS로 서버를 구성하여 WebServer, WAS, DB를 구성
 - 구성 시, 서버 한 대에 Docker를 사용하여 운영
 - 현재 DB서버의 경우 새로운 프로젝트로 대체되어 DB서버는 없는 상태

(2) Spring Boot       
(3) Spring Security      
JWT를 이용하여 구현하려다가 실패

3. 기능
-------
로그인       
회원가입      
회의실 예약      
이메일 전송     


### 빌드툴 설치(maven wrapper)  
```shell
mvn -N io.takari:maven:wrapper
```

### 빌드

```shell
cd 해당 디렉토리 위치
./mvnw spring-boot:run
```


### 설정 정보 
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.3/maven-plugin/reference/html/#build-image)

