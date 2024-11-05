package com.gradle.sb3stomp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.simp.SimpMessageSendingOperations;

@Slf4j
@Controller
public class StompChatController {
    @Autowired
    private SimpMessageSendingOperations msgTemplate;

    @MessageMapping("/stomp/message")
    public void message(StompMessageDto stompMessageDto) {
        log.info("/stomp/message => roomId:{}, msgType:{}, writer:{}, message:{}"
                , stompMessageDto.getRoomId()
                , stompMessageDto.getMsgType()
                , stompMessageDto.getWriter()
                , stompMessageDto.getMessage()
        );
        msgTemplate.convertAndSend("/sub/stomp/room/" + stompMessageDto.getRoomId()
                , stompMessageDto);
    }
}
