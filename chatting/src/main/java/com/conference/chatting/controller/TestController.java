package com.conference.chatting.controller;

import com.conference.chatting.model.request.TestReq;
import com.conference.chatting.model.response.TestRes;
import com.conference.chatting.model.wrapper.ResponseWrapper;
import com.conference.chatting.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/get/test")
    public ResponseEntity getTest(@RequestParam(value = "testParam") String testParam) {

        TestRes res = testService.test(testParam);

        return new ResponseEntity(new ResponseWrapper(res), HttpStatus.OK);

    }

    @PostMapping("/post/test")
    public ResponseEntity postTest(@RequestBody TestReq testReq, @RequestHeader(value = "testHeader") String testHeader) {

        TestRes res = testService.test(testReq, testHeader);

        return new ResponseEntity(new ResponseWrapper(res), HttpStatus.OK);

    }

}
