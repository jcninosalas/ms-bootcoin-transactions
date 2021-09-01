package com.everis.msbootcointransaccions.controller;

import com.everis.msbootcointransaccions.model.Transaction;
import com.everis.msbootcointransaccions.service.BootCoinTransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("bootcoin-transactions")
public class TransactionsController {

    @Autowired
    private BootCoinTransactionsService service;

    @PostMapping
    public Mono<?> transaction (Transaction transaction) {
        return service.transaction(transaction);
    }
}
