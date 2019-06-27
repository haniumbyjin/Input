package com.conference.push.service;

import com.conference.push.model.stock.StockTransaction;
import reactor.core.publisher.Flux;

public interface TestService {
    Flux<StockTransaction> getStockTransactions();
}
