package com.conference.push.controller;

import com.conference.push.model.enums.ResStatusCode;
import com.conference.push.model.response.Message;
import com.conference.push.model.response.TestRes;
import com.conference.push.model.wrapper.ResponseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import static org.slf4j.LoggerFactory.getLogger;

@Slf4j
@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private KafkaTemplate<String, Message> kafkaTemplate;

    private static final Logger logger = getLogger(KafkaController.class);

    @Autowired
    public KafkaController(KafkaTemplate<String, Message> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    
    @PostMapping("/test")
    public ResponseEntity send(@RequestBody Message testParam){

        logger.info("kafka - send");

        TestRes result = TestRes.builder().data(testParam).build();
        sendMessage("tutorialspoint", testParam);

        return new ResponseEntity(new ResponseWrapper(ResStatusCode.OK, result), HttpStatus.OK);
    }

    public void sendMessage(String topic, Message msg) {
        kafkaTemplate.send(topic, msg);
    }

    @KafkaListener(topics = "tutorialspoint", groupId = "group-id")
    public void listen(String message) {
        logger.info("Received Messasge in group - group-id: " + message);
    }
}
