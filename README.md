### WEBCHAT /w KAFKA 

 
```
JAVA 11
SPRING BOOT 2.7.1
GRADLE 7.6
KAFKA 2.13-3.2.0
DB (MongoDB) - Not yet
```

---

### DONE

* 프로젝트 init
  - VCS 설정 (git)
* KAFKA 및 ZOOKEEPER 설치 및 CLI 실행 확인
  - 서버 JAVA OPENJDK 11 설치 및 설정
  - zookeeper, kafka 설치 및 시스템데몬 등록
  - topic 생성 및 확인
  - cli producer, consumer 실행 및 확인
  
---

### TODO



* CI/CD 설정
  - github action
  - build > dockerize > deploy?

* websocket, STOMP 검토
* KAFKA TOPIC, PARTITION 검토 
  - room 단위는 어떻게 처리할까?
* github action workflow 작성
* github action properties 설정
  - properties 파일을 비공개 처리하면서 github action에서 설정할 수 있을까?
- 


---

### ERROR HANDLING


* error: invalid source release: 17
  - [PROJECT] build.gradle > sourceCompatibility = 11
  





