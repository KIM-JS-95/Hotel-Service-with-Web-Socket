package HotelService.controller;

import com.HotelService.entity.ChatMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@Log4j2
public class ChatController {


        @GetMapping("/chat")
    public void chatGET(){
            log.info("@ChatController, chat GET()");
        }

}
