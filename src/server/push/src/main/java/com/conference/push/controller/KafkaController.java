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
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;
import java.util.Date;

import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.web.servlet.mvc.method.annotation.SseEmitter.event;

@Slf4j
@RestController
@RequestMapping("/kafka")
public class KafkaController {

//    private KafkaTemplate<String, Message> kafkaTemplate;
//
//
//    @Autowired
//    public KafkaController(KafkaTemplate<String, Message> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }

//    @PostMapping("/test")
//    public ResponseEntity send(@RequestBody Message testParam){
//
//        log.info("kafka - send");
//        log.info("Send Messasge in group - group-id: " + testParam);
//
//        TestRes result = TestRes.builder().data(testParam).build();
//        sendMessage("tutorialspoint", testParam);
//
//        return new ResponseEntity(new ResponseWrapper(ResStatusCode.OK, result), HttpStatus.OK);
//    }
//
//    public void sendMessage(String topic, Message msg) {
//        kafkaTemplate.send(topic, msg);
//    }

    /* custom */
    @GetMapping("/rbe")
    @KafkaListener(topics = "tutorialspoint", groupId = "group-id")
    public ResponseEntity listen(Message message) throws IOException, InterruptedException{
        log.info("Received Messasge in group - group-id: " + message);
        ResponseBodyEmitter sseEmitter = new ResponseBodyEmitter();
        sseEmitter.send(event().name("message")
                .data(message));
        Thread.sleep(1000);
        sseEmitter.complete();
        return new ResponseEntity(new ResponseWrapper(ResStatusCode.OK, sseEmitter), HttpStatus.OK);
    }

    /* spring document test*/
//    @GetMapping("/srb")
//    @KafkaListener(topics = "tutorialspoint", groupId = "group-id")
//    public ResponseEntity<StreamingResponseBody> handleRbe() {
//        StreamingResponseBody stream = out -> {
//            String msg = "/srb" + " @ " + new Date();
//            out.write(msg.getBytes());
//        };
//        return new ResponseEntity(stream, HttpStatus.OK);
//    }

}
