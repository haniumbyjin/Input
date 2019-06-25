package com.conference.push.controller;

import com.conference.push.model.enums.ResStatusCode;
import com.conference.push.model.wrapper.ResponseWrapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Date;

import static org.springframework.web.servlet.mvc.method.annotation.SseEmitter.event;

@RestController
@RequestMapping("/sse-events")
public class TestSSEController {

    @RequestMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public SseEmitter handle() throws IOException, InterruptedException {
        SseEmitter sseEmitter = new SseEmitter();
        sseEmitter.send(event().name("message")
                .data(new Message("Hello, KSUG")));
        Thread.sleep(1000);
        sseEmitter.send(event().name("greeting").data(
                new Greeting("Hello, Honeymon")));
        Thread.sleep(1000);
        sseEmitter.send(event().name("date").data(new Date()));
        Thread.sleep(1000);
        sseEmitter.complete();
        return sseEmitter;
    }

    @RequestMapping(path = "/test", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public ResponseEntity handle2() throws IOException, InterruptedException {
        SseEmitter sseEmitter = new SseEmitter();
        sseEmitter.send(event().name("message")
                .data(new Message("Hello, KSUG")));
        Thread.sleep(1000);
        sseEmitter.send(event().name("greeting").data(
                new Greeting("Hello, Honeymon")));
        Thread.sleep(1000);
        sseEmitter.send(event().name("date").data(new Date()));
        Thread.sleep(1000);
        sseEmitter.complete();
        return new ResponseEntity(new ResponseWrapper(ResStatusCode.OK, sseEmitter), HttpStatus.OK);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Message {
        private String content;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Greeting {
        private String content;
    }
}
