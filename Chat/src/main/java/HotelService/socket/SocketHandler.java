package HotelService.socket;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
@Log4j2
public class SocketHandler extends TextWebSocketHandler {

    HashMap<String, WebSocketSession> sessionMap = new HashMap<>(); //웹소켓 세션을 담아둘 맵


    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception{
        //메시지 발송
        String msg = message.getPayload();
        for(String key : sessionMap.keySet()) {
            WebSocketSession wss = sessionMap.get(key);
            try {
                wss.sendMessage(new TextMessage(msg));
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }


    /* 클라이언트 호출 */
    @Override
    public void afterConnectionEstablished(WebSocketSession session)throws Exception{
        //소켓 연결
        super.afterConnectionEstablished(session);
        sessionMap.put(session.getId(), session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception{
        //소켓 종료
        sessionMap.remove(session.getId());
        super.afterConnectionClosed(session, status);
    }
}