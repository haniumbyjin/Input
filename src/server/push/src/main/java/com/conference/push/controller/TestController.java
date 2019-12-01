package com.conference.push.controller;

import com.conference.push.model.enums.ResStatusCode;
import com.conference.push.model.request.TestReq;
import com.conference.push.model.response.TestRes;
import com.conference.push.model.stock.StockTransaction;
import com.conference.push.model.wrapper.ResponseWrapper;
import com.conference.push.service.TestService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.util.Date;

import static org.springframework.web.servlet.mvc.method.annotation.SseEmitter.event;

@RestController
@RequestMapping("/stock/transaction")
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping(produces = "application/stream+json")
    public Flux<StockTransaction> stockTransactionEvents(){
        return testService.getStockTransactions();
    }

    @GetMapping("/test")
    public ResponseEntity getTest(@RequestParam(value="testParam") String testParam) {

        TestRes res = testService.test(testParam);

        return new ResponseEntity(new ResponseWrapper(ResStatusCode.OK, res), HttpStatus.OK);
    }

    @PostMapping("/test")
    public ResponseEntity postTest(@RequestBody TestReq testReq, @RequestHeader(value = "testHeader") String testHeader) {

        TestRes res = testService.test(testReq, testHeader);

        return new ResponseEntity(new ResponseWrapper(ResStatusCode.OK, res), HttpStatus.OK);

    }

}
