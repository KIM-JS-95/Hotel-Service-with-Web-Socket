package com.AbstractCnS.controller;


import com.AbstractCnS.entity.ChatRoom;
import com.AbstractCnS.entity.response.ChatRoomResponse;
import com.AbstractCnS.service.ChatRoomResponseService;
import com.AbstractCnS.service.IChatRoomService;
import com.AbstractCnS.service.IMessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@CrossOrigin(origins = "*")
@Slf4j
@RequestMapping("/api/chat")
@RequiredArgsConstructor
@RestController
public class ChatRoomController {

    private final IChatRoomService chatroomService;
    private final IMessageService messageService;
    private final ChatRoomResponseService chatroomResService;
    final int PAGE = 10;

    @GetMapping("/rooms/{id}")
    //@ApiOperation("해당 유저의 모든 채팅방 목록 조회 및 정보전달")
    public ResponseEntity<ChatRoomResponse[]> room(@PathVariable long id){
        List<ChatRoom> joinedChatRoomList = chatroomService.getJoinedRoomList(id);
        ChatRoomResponse[] chatroomResList = new ChatRoomResponse[joinedChatRoomList.size()];
        log.info(joinedChatRoomList.toString());

        for (int i = 0; i < joinedChatRoomList.size(); i++) {
            ChatRoom cr = joinedChatRoomList.get(i);
            if (cr.getUser1Id() == id) {
                chatroomResList[i] = ChatRoomResponse.builder().id(cr.getId()).currUserId(id)
                        .otherUserId(cr.getUser2Id()).build();
                chatroomResList[i].setEntity(chatroomResService.getChatRoomInfo(chatroomResList[i]));
                System.out.println(chatroomResList[i]);
            } else if (cr.getUser2Id() == id) {
                chatroomResList[i] = ChatRoomResponse.builder().id(cr.getId()).currUserId(id)
                        .otherUserId(cr.getUser1Id()).build();
                chatroomResList[i].setEntity(chatroomResService.getChatRoomInfo(chatroomResList[i]));
                System.out.println(chatroomResList[i]);
            } else {
                log.error("logic error");
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
            }
        }

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    }

}
