package com.conference.chatting.controller;

import com.conference.chatting.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RestController
public class MessageController {

    @MessageMapping("/chat")
    @SendTo("/topic/roomId")
    public Message broadcasting(Message message) throws Exception{
        log.info("message = " + message);

        DateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date nowDate = new Date();
        String date = sdFormat.format(nowDate);
        message.setTimeStamp(date);

        return message;
    }
}
