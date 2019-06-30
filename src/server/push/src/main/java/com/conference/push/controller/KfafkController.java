package com.conference.push.controller;

import com.conference.push.model.enums.ResStatusCode;
import com.conference.push.model.response.Message;
import com.conference.push.model.response.TestRes;
import com.conference.push.model.stock.StockTransaction;
import com.conference.push.model.wrapper.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/kafka")
public class KfafkController {

    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;

    /*
    test url : http://localhost:8080/kafka/test
    body :
    {
	"message" : "hi"
    }
     */
    @PostMapping("/test")
    public ResponseEntity send(@RequestBody Message testParam){

        System.out.println("kafka - send");

        TestRes result = TestRes.builder().data(testParam).build();
        sendMessage("tutorialspoint", testParam);

        return new ResponseEntity(new ResponseWrapper(ResStatusCode.OK, result), HttpStatus.OK);
    }

    public void sendMessage(String topic, Message msg) {
        kafkaTemplate.send(topic, msg);
    }

    @KafkaListener(topics = "tutorialspoint", groupId = "group-id")
    public void listen(String message) {
        System.out.println("Received Messasge in group - group-id: " + message);
    }
}
