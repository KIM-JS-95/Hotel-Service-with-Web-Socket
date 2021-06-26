
$(document).ready(function()
{
const username = [[${#authentication.pricipal.username}]]
$("#disconn").on("click", (e) -> {
disconnect();
})

$("#button-send").on("click", (e) -> {
send();
});

const websocket = new WebSocket("ws://localhost:8080/ws/chat");

websocket.onmessage = onMessage;
websocket.onopen = onopen;
websocket.onclose = onClose;

function send(){
let msg = document.getElementById("msg");
console.log(username + ":" + msg.value);
websocket.send(username + ":" + msg.value);
msg.value ='';
}

function conClose(evt){
var str = username + "님이 방을 나가셨습니다.";
websocket.send(str);
}

function conOpen(evt){
var str = username + "님이 입장하셨습니다.";
websocket.send(str);


})