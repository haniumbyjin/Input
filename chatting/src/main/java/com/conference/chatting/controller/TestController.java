package com.conference.chatting.controller;

import com.conference.chatting.model.enums.ResStatusCode;
import com.conference.chatting.model.request.TestReq;
import com.conference.chatting.model.response.TestRes;
import com.conference.chatting.model.swagger.SwgTestRes;
import com.conference.chatting.model.wrapper.ResponseWrapper;
import com.conference.chatting.service.TestService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = SwgTestRes.class)
    })
    public ResponseEntity getTest(@RequestParam(value = "testParam") String testParam) {

        TestRes res = testService.test(testParam);

        return new ResponseEntity(new ResponseWrapper(ResStatusCode.OK, res), HttpStatus.OK);

    }

    @PostMapping("/post/test")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = SwgTestRes.class)
    })
    public ResponseEntity postTest(@RequestBody TestReq testReq, @RequestHeader(value = "testHeader") String testHeader) {

        TestRes res = testService.test(testReq, testHeader);

        return new ResponseEntity(new ResponseWrapper(ResStatusCode.OK, res), HttpStatus.OK);

    }

}
