package com.conference.chatting.controller;

import com.conference.chatting.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MessageController {

    @MessageMapping("/chat")
    public Message broadcasting(Message message) throws Exception{
        return message;
    }
}
