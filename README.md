# My Schedule App Server

## About The Project
일정을 추가, 조회, 수정, 삭제 (CRUD) 를 할 수 있는 서버를 Spring Boot로 구현하였습니다.

## Built With
- Java(jdk17)
- Spring Boot(3.1.8)
- Github

## How To Run
1. 프로젝트를 다운로드한 뒤 선호하는 IDE(intelliJ IDEA)로 프로젝트를 연다.
2. src/main/resources 에 application.properties를 추가한다.
3. 파일 안에 사용할 MySQL 데이버베이스를 설정한다.
4. 프로그램을 구동한 뒤 Postman을 활용하여 (POST/ GET/ PUT/ DELETE) 명령어 전송한다. 

## 프로젝트 구성
### 요청 방법
- port : 8080
- http://localhost:8080/api/원하는API입력하세요
  
### 기본 Entity 인 Schedule은 6가지 필드를 가지고 있다.
> Long id  
> String title  
> String contents  
> String manager  
> String password  
> int date  

프로젝트에서 5가지 기능 구현하였다.
1. POST : 일정 추가  
   원하는 일정을 추가한다.
   API예)  [POST]method   &&   http://localhost:8080/api/schedule
3. GET : 일정 조회  
   일정을 조회하게 되면 비밀번호를 제외한 내용을 확인할 수 있다.
   - 특정 일정 조회  
     API예)  [GET]   &&   http://localhost:8080/api/schedule?id={int id}  
   - 모든 일정을 목록으로 조회  
     API예)  [GET]   &&   http://localhost:8080/api/schedules
5. PUT : 일정 수정  
   특정 일정을 선택하여 수정한다. password가 일치한 경우에만 수정이 가능하다.  
   API예)  [PUT]   &&   http://localhost:8080/api/schedule?id={int id}
6. DELETE : 일정 삭제  
   특정 일정을 선택하여 삭제한다. password가 일치한 경우에만 삭제가 가능하다.  
   API예)  [DELETE]   &&   http://localhost:8080/api/schedule?id={int id}&password={String password}

# About ME

> 이름 : 나현승  
> [Github : github.com/dbfjru](https://github.com/dbfjru)  
> [Blog : always-be-poisitve.tistory.com](https://always-be-poisitve.tistory.com/)  

