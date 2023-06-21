# DBP_TOrders

<div align="center">
<img width="150" alt="image" src="https://github.com/yunju-m/DBP_TOrders/assets/74498379/75391350-d558-4fae-8f20-06a6283083d6">

[![Hits](https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2FVoluntain-SKKU%2FVoluntain-2nd&count_bg=%2379C83D&title_bg=%23555555&icon=&icon_color=%23E7E7E7&title=hits&edge_flat=false)](https://hits.seeyoufarm.com)

</div>

# DBP_TOrders 혼밥은 시로시로 웹사이트
> **강원대학교 컴퓨터공학과 데이터베이스프로그래밍 프로젝트** <br/> **개발기간: 2023.03.23 ~ 2023.06.20**
<br/>

## 웹개발팀 소개

| 마윤주 | 최무리 | 함지연 | 이효민 | 전혜지 |                                                                                                             
| :-----: | :-----: | :-----: | :-----: | :-----: | 
| 강원대학교 컴퓨터공학과 4학년 | 강원대학교 컴퓨터공학과 4학년 | 강원대학교 컴퓨터공학과 4학년 | 강원대학교 컴퓨터공학과 4학년 | 강원대학교 컴퓨터공학과 4학년 |

## 프로젝트 소개

코로나로 인한 배달 주문이 급상승하면서 동시에 배달료가 상승하였다. 이로인해 일반 대학생, 학생들에게는 해당 배달료로 인한 경제적 부담감을 느끼는 경우가 많았다. 또한, 코로나로 인해 온라인 수업으로 대체되면서 코로나 학번의 경우 학과 동기들과 만나는 시간도 줄어드는 문제가 발생했다. 이러한 문제를 해결하기위해 함께 배달시켜 먹을 사람을 구하는 '혼밥은 시로시로' 웹페이지 구축을 시작하게 되었다.


## 시작 가이드
앞서, 수업에서 배운 jdbc, jpa, mybatis을 모두 이용하여 구현하였다.

### Requirements
For building and running the application you need:

- [JDK 1.8 이상](https://www.oracle.com/kr/java/technologies/downloads/)
- [Springboot 2.7 이상](https://start.spring.io/)

### Installation
``` bash
$ git clone https://github.com/yunju-m/DBP_TOrders
$ cd DBP_TOrders
```
#### dependencides
```
implementation 'org.springframework.boot:spring-boot-starter-jdbc'
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
implementation 'org.springframework.boot:spring-boot-starter-web'
implementation 'org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.0'
implementation 'org.mariadb.jdbc:mariadb-java-client:2.1.2'
implementation 'com.googlecode.json-simple:json-simple:1.1.1'
compileOnly 'org.projectlombok:lombok'
developmentOnly 'org.springframework.boot:spring-boot-devtools'
runtimeOnly 'org.mariadb.jdbc:mariadb-java-client'
annotationProcessor 'org.projectlombok:lombok'
testImplementation 'org.springframework.boot:spring-boot-starter-test'
```

#### application.properties
```
spring.datasource.driverClassName=org.mariadb.jdbc.Driver
spring.datasource.url=jdbc:mariadb://127.0.0.1:3306/torders
spring.datasource.username=root
spring.datasource.password=system

mybatis.configuration.map-underscore-to-camel-case= true
mybatis.type-aliases-package=com.example.torder.entity
mybatis.mapper-locations=mappers/*.xml
```

---

## Stacks 🐈

### Environment
![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-007ACC?style=for-the-badge&logo=Visual%20Studio%20Code&logoColor=white)
![IntelliJ](https://img.shields.io/badge/IntelliJ-000000?style=for-the-badge&logo=IntelliJidea&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=Git&logoColor=white)
![Github](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=GitHub&logoColor=white)                    

### Development
![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=OpenJDK&logoColor=white)
![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=Spring&logoColor=white)
![Html](https://img.shields.io/badge/Html-E34F26?style=for-the-badge&logo=Html5&logoColor=white)
![Css](https://img.shields.io/badge/Css-1572B6?style=for-the-badge&logo=Css3&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=Javascript&logoColor=white)
![JQuery](https://img.shields.io/badge/JQuery-0769AD?style=for-the-badge&logo=jQuery&logoColor=white)
![MariaDB](https://img.shields.io/badge/MariaDB-003545?style=for-the-badge&logo=MariaDB&logoColor=white)
![Bootstrap](https://img.shields.io/badge/Bootstrap-7952B3?style=for-the-badge&logo=Bootstrap&logoColor=white)

### Communication
![Notion](https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=Notion&logoColor=white)
![GoogleMeet](https://img.shields.io/badge/GoogleMeet-00897B?style=for-the-badge&logo=Google%20Meet&logoColor=white)
![kakaotalk](https://img.shields.io/badge/Kakaotalk-FFCD00?style=for-the-badge&logo=Kakaotalk&logoColor=white)

---
## 화면 구성 📺
| 로그인 페이지 | 회원가입 페이지 |
| :---------: | :-----------: |
| <img width="329" src="https://github.com/yunju-m/DBP_TOrders/assets/74498379/b6c0ceb1-21e7-476d-b1ee-8659f06da85a"/> | <img width="329" src="https://github.com/yunju-m/DBP_TOrders/assets/74498379/4ee9efa9-d01e-4217-8730-8b324ba13d88"/> |

| 메인 페이지(카탈로그) | 메인페이지(게시판) | 상세 게시글 페이지 |
| :-----------: | :-----------: | :-----------: |   
| <img width="329" src="https://github.com/yunju-m/DBP_TOrders/assets/74498379/c4d82e27-e1ab-4062-986b-9d3b9bea9c05"/> | <img width="329" src="https://github.com/yunju-m/DBP_TOrders/assets/74498379/ffc6d667-4678-4519-a5ad-5d02a42fe5a5"/> | <img width="329" src="https://github.com/yunju-m/DBP_TOrders/assets/74498379/392016c5-e54f-4ae3-b322-67a9f1239620"/> |

| 마이페이지(참여 게시글) | 마이페이지(정보) | 마이페이지(소개) |
| :-----------: | :-----------: | :-----------: |   
| <img width="329" src="https://github.com/yunju-m/DBP_TOrders/assets/74498379/4c2adf59-a708-491a-b1a1-0147480e1b0a"/> | <img width="329" src="https://github.com/yunju-m/DBP_TOrders/assets/74498379/d60c8054-3aa4-4193-9598-30b5b55d270b"/> | <img width="329" src="https://github.com/yunju-m/DBP_TOrders/assets/74498379/6f68ff75-4f8c-4f44-8797-e21dbf99ce9a"/> |

---
## 주요 기능 📦

### ⭐️ 회원가입 및 로그인
- 사용자는 회원가입을 통해 해당 사이트 이용 가능
- 중복 아이디, 닉네임은 사용 불가능
- 비밀번호 일치한지 여부 판단
- 로그인 성공 시 메인 페이지로 이동

### ⭐️ 카탈로그을 이용한 게시물
- 카탈로그를 선택하여 해당 게시물의 내용만 선택 가능
- 글쓰기 버튼을 클릭하여 게시물 작성 가능
- 글보기 버튼을 클릭하여 게시물의 상세 페이지로 이동하여 상세 내용 확인 가능

### ⭐️ 마이페이지
- 마이페이지에서 참여한 게시글에 대해 확인 가능
- 탈퇴버튼 클릭 시 참여한 게시글에 대해 불참
- 내 정보에 대해 확인 가능
- 나를 소개하는 글

---
## 아키텍쳐

### 디렉토리 구조
```bash
├── gradle
├── vscode
├── bin
├── gradle
├── src 
│   ├── main : 주요 기능을 수행하는 폴더
│       ├── java.com.torders : 백엔드
│       │   ├── controller
│       │   |   ├── HomeController : 로그인 페이지 기능
│       │   |   ├── MainController : 메인 페이지 기능
│       │   |   ├── MyPageController : 마이페이지 기능
│       │   |   ├── MyController : 상세글 페이지 기능
│       │   |   ├── WriteController : 게시글 기능
│       │   |   ├── HomeController : 로그인 페이지 기능
│       │   |   ├── HomeController : 로그인 페이지 기능
│       │   ├── Form : 입력한 정보 저장 객체
│       │   |   ├── LoginForm : 로그인 정보 저장
│       │   |   ├── MatchingForm : 해당 사용자와 게시글 매칭 정보 저장
│       │   ├── domain : 데이터베이스 저장소
│       │   |   ├── Category : 카테고리 정보 저장
│       │   |   ├── Content : db에 저장된 content내용을 저장해서 특정 정보 추출할 때 사용
│       │   |   ├── Member : 회원가입 창에서 입력한 id, pw, nick 정보 저장
│       │   |   ├── MyUserPage : 매칭 정보 저장
│       │   |   ├── NowContent : 새로운 게시글 작성 정보
│       │   ├── entity
│       │   |   ├── ContentEntity :
│       │   |   ├── Contents
│       │   |   ├── MyPageMatching
│       │   |   ├── MyPageUserEntity
│       │   ├── repository
│       │   |   ├── ContentRepository
|       |   |   |   ├── getTotalContent() : 첫 시작 전체 게시글 가져옴
|       |   |   |   ├── getTotalCategory() : 첫 시작 전체 카테고리 가져옴
|       |   |   |   ├── getCategoryContentInfo() : 해당 카테고리의 모든 게시글 가져옴
|       |   |   |   └── getContentInfo() : 특정 게시글 정보 가져      
│       │   |   ├── JdbcContentRepository
│       │   |   ├── JdbcMemberRepository
│       │   |   ├── MemberRepository
|       |   |   |   ├── existMembersave() : 존재하는 모든 사용자 정보 저장
|       |   |   |   ├── loginCheck() : 로그인 성공 여부 판단
|       |   |   |   ├── save() : 입력한 회원 정보 저장
|       |   |   |   ├── findById() : 중복되는 아이디 확인
|       |   |   |   └── findByNickname() : 중복되는 닉네임 확인
│       │   |   ├── MyPageUserRespository
│       │   |   ├── NowContentRepository
│       │   |   ├── WriteRepository
│       │   ├── service
│       │   |   ├─ ContentService
│       │   |   ├── MemberService
│       │   |   ├── MyPageUserService
│       │   |   ├── NowContentService
│       │   |   └── WriteService
│       ├── config : 서버, 데이터베이스 관련 정보 폴더
│       │   ├── mybatis-confing
│       │   ├── SpringConfig
│       │   └── TorderApplication
│       │  
│       ├── resources : 프론트엔드
│       │   ├── mappers
|       |   |   |   ├── content.xml
|       |   |   |   ├── users.xml
│       │   ├── static : 프론트 기능 구현
|       |   |   |   ├── css
|       |   |   |   |   ├── home.css
|       |   |   |   |   ├── login.css
|       |   |   |   |   ├── main.css
|       |   |   |   |   ├── mypage.css
|       |   |   |   |   ├── page.css
|       |   |   |   |   └── write.css
|       |   |   |   ├── img : 사용된 이미지 저장 폴더
|       |   |   |   ├── js
|       |   |   |   |   ├── home.js
|       |   |   |   |   ├── login.js
|       |   |   |   |   ├── main.js
|       |   |   |   |   ├── swiper.js
|       |   |   |   |   └── content.js
|       |   |   |   ├── index.html : 기본 html
│       │   ├── templates : 모든 홈페이지 html
|       |   |   ├── home.html
|       |   |   ├── logForm.html
|       |   |   ├── main.html
|       |   |   ├── mypage.html
|       |   |   ├── page.html
|       |   |   └── write.html 
│       ├── properties : database, mybatis 연결 정보
│       |   └── application.properties
│       |
|       └── test
|            └── TorderApplicationTest
├── README.md
└── setting.gradle
```
