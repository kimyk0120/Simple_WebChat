### WEBCHAT /w KAFKA 

 
```
JAVA 11
SPRING BOOT 2.7.1
GRADLE 7.6
KAFKA 2.13-3.2.0
DB (MongoDB) - Not yet
Bootstrap 5.2.2
```

---

### DONE

* 프로젝트 init
  - VCS 설정 (git)
* KAFKA 및 ZOOKEEPER 설치 및 CLI 실행 확인 (port:9092)
  - 서버 JAVA OPENJDK 11 설치 및 설정
  - zookeeper, kafka 설치 및 시스템데몬 등록
  - topic 생성 및 확인
  - cli producer, consumer 실행 및 확인
* PROJECT WELCOME PAGE 설정
  - static resource > index.html
* css framework 선정
  - Bootstrap (o)
* Template Engine Thymeleaf Dependency 추가
* TEST Controller 생성
* fire wall : iptables -I INPUT 1 -p tcp --dport 8080 -j ACCEPT

---

### TODO


* CI/CD 설정
  - GitHub action 
    +  deploy yml 작성 (jar서버전송까지 완료)

* JAVA-KAFKA 설정 및 연동 테스트
  - producer
  - consumer
  
  
* websocket, STOMP 검토
* KAFKA TOPIC, PARTITION 검토 
  - room 단위는 어떻게 처리할까?
* GitHub action workflow 작성
* GitHub action properties 설정
  - properties 파일을 비공개 처리하면서 github action에서 설정할 수 있을까?
* DB 설계


---

### ERROR HANDLING


* error: invalid source release: 17
  - [PROJECT] build.gradle > sourceCompatibility = 11
  





