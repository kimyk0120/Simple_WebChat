## WEBCHAT w/ KAFKA 



## 1. Introduction

This is a simple webchat application that uses Kafka as a message broker. It is a simple application that uses the following tools:
```
JAVA 11
SPRING BOOT 2.7.1
GRADLE 7.6
KAFKA 2.13-3.2.0
DB (MongoDB) - Not yet
Bootstrap 5.2.2
```

---

### 2. DONE

* 프로젝트 init
  - VCS 설정 (git)
* PROJECT WELCOME PAGE 설정
  - static resource > index.html
* css framework 선정
  - Bootstrap5
* Template Engine Thymeleaf 설정
* CI/CD 설정
  - GitHub action
    +  deploy.yml, deploy.sh 작성 및 테스트 완료
* KAFKA 및 ZOOKEEPER 설치 및 CLI 실행 확인 (port:9092)
  - 서버 JAVA OPENJDK 11 설치 및 설정
  - zookeeper, kafka 설치 및 시스템데몬 등록
  - topic 생성 및 확인
  - cli producer, consumer 실행 및 확인
* JAVA-KAFKA 설정 및 연동 테스트
  - producer, consumer, topic
* 로그인 화면 UI 구현
  * Nick input form, toast message, validation, thymeleaf layout 설정

---

### 3. TODO

* chatRooms 화면 UI 구현
  - chatRoom list
* ApplicationContext - ApplicationEvent 검토 및 활용 범위 검토  
* websocket, STOMP 검토
* KAFKA TOPIC, PARTITION 검토 
  - room 단위는 어떻게 처리할까?
* DB 설계


---

### 4. ERROR HANDLING

* error: invalid source release: 17
  - [PROJECT] build.gradle > sourceCompatibility = 11
* layout:decorate="~{layout/default_layout} 작동안함
  - [PROJECT] build.gradle > implementation 'nz.net.ultraq.thymeleaf:thymeleaf-layout-dialect' 추가
* js Keydown 이벤트 한글 중복 입력 현상 
  - https://kwangsunny.tistory.com/33 ; , 한글이나 중국어같이 영어가 아닌 글자들은 한 글자가 영어보다 많은 정보를 담고있기 때문에 키입력 순간부터 입력완료 까지 시간이 걸리고, 이는 keydown 이벤트가 이미 발생되고 난 후에도 진행중일 수 있다
  - 방안 keydown => keypress 로 변경

---

### 5. REFERENCE & TIPS

* fire wall : iptables -I INPUT 1 -p tcp --dport 8080 -j ACCEPT
* https://mdbootstrap.com/docs/standard/getting-started/installation/ 
* https://getbootstrap.kr/


