## 역할

>beack -end / DB modeling

## 구현 파트

``` bash
1. Guest 체크 인/아웃 기능
2. Admin Guest 정보 관리 및 수정
3. STOMP를 활용한 실시간 채팅 기능 구현
4. 호텔 부가 서비스(청소 및 비품 요청) 주문 기능
5. 방 형태 및 빈방 검색 기능
```

## 1. real-time chat system
> 구현기간: 2021-04-19 ~~


## WebSocket
``` bash
Websocket은 기본의 단방햘 HTTP 프로토콜과 호환되어 양방향 통신을 제공하기 위해 개발된 프로토콜이다.
일반 통신과 달리 http 80 Port를 이용하여 방화벽 제약이 없다.


dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.boot:spring-boot-starter-websocket'
}
```