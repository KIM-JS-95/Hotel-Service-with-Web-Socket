# Title

### 구현 파트

``` bash
1. Guest 체크 인/아웃 기능 (O)
2. Admin Guest 정보 관리 및 수정 (O)
3. STOMP를 활용한 실시간 채팅 기능 구현
4. 호텔 부가 서비스(청소 및 비품 요청) 주문 기능
5. 방 형태 및 빈방 검색 기능
6. reservation Request event 요청 Sse 기능 구현 
```


### WebSocket
``` bash
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