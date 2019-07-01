package com.conference.push.controller;

import com.conference.push.model.enums.ResStatusCode;
import com.conference.push.model.response.Message;
import com.conference.push.model.response.TestRes;
import com.conference.push.model.stock.StockTransaction;
import com.conference.push.model.wrapper.ResponseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@Slf4j
@RestController
@RequestMapping("/kafka")
public class KfafkController {

    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;

    private static final Logger logger = LoggerFactory.getLogger(KfafkController.class);

    /*
    test url : http://localhost:8080/kafka/test
    body :
    {
	"message" : "hi"
    }
     */
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
