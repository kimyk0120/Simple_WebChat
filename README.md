## WEBCHAT w/ KAFKA 



## 1. Introduction

This is a simple webchat application that uses Kafka as a message broker. It is a simple application that uses the following tools:
```
JAVA 11
SPRING BOOT 2.7.1
GRADLE 7.6
KAFKA 2.13-3.2.0
MongoDB 5.0.14
MDBootstrap 6.1.0
ThymeLeaf 3.0.15
``` 

---

### 2. DONE

* 프로젝트 init
  - VCS 설정 (git)
* PROJECT WELCOME PAGE 설정
  - static resource > index.html
* css framework 선정 > MDBootstrap
* Template Engine 설정 > Thymeleaf
* CI/CD 설정 > GitHub action
  - deploy.yml, deploy.sh 작성 및 테스트 
* KAFKA 및 ZOOKEEPER 설치 및 CLI 실행 확인 (port:9092)
  - 서버 JAVA OPENJDK 11 설치 및 설정
  - zookeeper, kafka 설치 및 시스템데몬 등록
  - topic 생성 및 확인
  - cli producer, consumer 실행 및 확인
* JAVA-KAFKA 설정 및 연동 테스트
  - producer, consumer, topic
* 로그인 화면 UI 구현
  * Nick input form, toast message, validation, thymeleaf layout 설정
  * toastify, axios 라이브러리 추가
* DB
  - MongoDB svr 설치 및 설정
  - DB 연동 및 테스트
  - DB properties secret 처리

---

### 3. TODO


* chatRooms 화면 UI 구현
  - chatRoom list layout: chat 목록 나열, chatRoom 생성 버튼, ~~chatRoom 입장 버튼~~
* chatRomm 화면 UI 구현
  - chatRoom layout: chatRoom title, chatRoom 입장자 목록, chatRoom 채팅창, chatRoom 채팅 입력창, chatRoom 나가기 버튼, chat Message layout
* ApplicationContext - ApplicationEvent 검토 및 활용 범위 검토  
* websocket, STOMP 검토
* KAFKA TOPIC, PARTITION 검토 
  - room 단위는 어떻게 처리할까?



---

### 4. ERROR HANDLING

* error: invalid source release: 17
  - [PROJECT] build.gradle > sourceCompatibility = 11
* layout:decorate="~{layout/default_layout} 작동안함
  - [PROJECT] build.gradle > implementation 'nz.net.ultraq.thymeleaf:thymeleaf-layout-dialect' 추가
* js Keydown 이벤트 한글 중복 입력 현상 
  - https://kwangsunny.tistory.com/33 ; , 한글이나 중국어같이 영어가 아닌 글자들은 한 글자가 영어보다 많은 정보를 담고있기 때문에 키입력 순간부터 입력완료 까지 시간이 걸리고, 이는 keydown 이벤트가 이미 발생되고 난 후에도 진행중일 수 있다
  - 방안 keydown => keypress 로 변경
* 컨트롤러 두 번씩 호출 현상 
  - href="#" 으로 인한 문제
* thymeleaf : template might not exist ..... 
  - templates의 상대경로로 잡아줘야함  /layout/default_layout.html > layout/default_layout.html
  - https://jamong-icetea.tistory.com/190
  

---

### 5. REFERENCE & TIPS

* fire wall CMD: iptables -I INPUT 1 -p tcp --dport 8080 -j ACCEPT
* MDB : https://mdbootstrap.com/docs/standard/getting-started/installation/ 
* Bootstrap Doc : https://getbootstrap.kr/
* Chat UI : https://mdbootstrap.com/docs/standard/design-blocks/chat/
* MongoDb : https://www.infracody.com/2022/05/install-mongodb-on-centos-7.html
* Kafka Topic Naming Convention : https://data-engineer-tech.tistory.com/36
* mongodb conf path : /etc/mongod.conf


