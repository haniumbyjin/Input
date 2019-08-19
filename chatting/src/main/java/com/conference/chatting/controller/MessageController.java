package com.conference.chatting.controller;

import com.conference.chatting.model.Message;
import com.conference.chatting.model.enums.ReqCity;
import com.conference.chatting.model.enums.ReqNation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

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

//        LocalDate currentDate = LocalDate.now();
        TimeZone tz = TimeZone.getTimeZone(ReqNation.Asia.getMessage() + "/" + ReqCity.Seoul.getMessage());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
        df.setTimeZone(tz);
        String nowAsISO = df.format(new Date());

        message.setTimeStamp(nowAsISO);

        log.info("message = " + message);

        //redis로 저장하기

        //kafka로 보내기
        log.info("kafka - send");
//        kafkaTemplate.send("tutorialspoint", message);


        return message;
    }
}
