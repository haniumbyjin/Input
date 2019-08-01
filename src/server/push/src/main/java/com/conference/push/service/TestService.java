package com.conference.push.service;

import com.conference.push.model.request.TestReq;
import com.conference.push.model.response.TestRes;
import com.conference.push.model.stock.StockTransaction;
import reactor.core.publisher.Flux;

public interface TestService {
    Flux<StockTransaction> getStockTransactions();

    TestRes test(String testParam);

    TestRes test(TestReq testReq, String testHeader);
}
