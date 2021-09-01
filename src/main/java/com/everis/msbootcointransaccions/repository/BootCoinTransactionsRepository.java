package com.everis.msbootcointransaccions.repository;

import com.everis.msbootcointransaccions.model.BootCoinTransactions;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface BootCoinTransactionsRepository extends ReactiveMongoRepository<BootCoinTransactions, String> {

    Mono<BootCoinTransactions> findByPhoneNumber(String phoneNumber);
}
