# HOTEL (Chat PART)

```bash
각 호실별 채팅 기능 구현
```
---

```bash
port: 
localhost:3306
```

웹 소켓을 적용하여 실시간 양방향 채팅 기능 구현
웹 프론트는 thymeleaf 를 적용하여 구현

```
dependencies {

    implementation 'org.springframework.boot:spring-boot-starter-websocket'
    implementation 'org.webjars:sockjs-client:1.1.2'
    implementation 'org.webjars:stomp-websocket:2.3.3-1'

    implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
}
```

## Reference
[websocket 채팅 구현](https://dev-gorany.tistory.com/235)