package com.conference.push.controller;

import com.conference.push.model.stock.StockTransaction;
import com.conference.push.service.TestService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<StockTransaction> stockTransactionEvents(){
        return testService.getStockTransactions();
    }



}
