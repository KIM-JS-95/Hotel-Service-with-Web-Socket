# Hotel Service with Web-Socket 

호텔 서비스에 필요한 각 기능들을 Guest / Admin / Chat 3가지로 분류하여 구현하였습니다.



**파트별 README.md 파일 확인하기**
* [Guest_part README.md](./Guest/README.md)
* [Hotel_part README.md](./Hotel/README.md)

---

### 구현 파트


### WebSocket
```
Websocket은 기본의 단방햘 HTTP 프로토콜과 호환되어 양방향 통신을 제공하기 위해 개발된 프로토콜이다.
일반 통신과 달리 http 80 Port를 이용하여 방화벽 제약이 없다.


dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.boot:spring-boot-starter-websocket'
}
```

### Server - sent Event
``` bash
SSE를 사용하여 통신 할 때 서버는 초기 요청을 하지 않고도 필요할 때마다 데이터를 앱으로 푸시 할 수 있다. 
즉, 서버에서 클라이언트로 업데이트를 스트리밍 할 수 있다. 
SSE는 서버와 클라이언트 사이에 단일 단방향 채널을 사용한다.


dependencies {
   implementation 'org.springframework.boot:spring-boot-starter-webflux'
}
```

## 구현기간:
> 2021-04-19 ~~

## Skill
> Junit 4
>
> Gradle
>
> Spring Boot ver.2.2.1.RELEASE
>
> TDD(Test Driven Development)
> 
> Mustache

## Pattern
> Singleton Pattern
>
> Layered Pattern