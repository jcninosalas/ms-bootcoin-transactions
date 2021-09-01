package com.everis.msbootcointransaccions.service;

import com.everis.msbootcointransaccions.model.Transaction;
import reactor.core.publisher.Mono;

import java.util.Map;

public interface BootCoinTransactionsService {

    Mono<Object> transaction(Transaction transaction);
}
