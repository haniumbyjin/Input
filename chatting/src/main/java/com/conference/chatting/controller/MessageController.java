package com.conference.chatting.controller;

import com.conference.chatting.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@Slf4j
@RestController
public class MessageController {

    private KafkaTemplate<String, Message> kafkaTemplate;


    @Autowired
    public MessageController(KafkaTemplate<String, Message> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @MessageMapping("/chat")
    @SendTo("/topic/roomId")
    public Message broadcasting(Message message) throws Exception{

        LocalDate currentDate = LocalDate.now();
        message.setTimeStamp(currentDate.toString());

        log.info("message = " + message);

        //redis로 저장하기

        //kafka로 보내기
        log.info("kafka - send");
        kafkaTemplate.send("tutorialspoint", message);


        return message;
    }
}
