package com.everis.msbootcointransaccions.repository;

import com.everis.msbootcointransaccions.model.BootCoinTransactions;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BootCoinTransactionsRepository extends ReactiveMongoRepository<BootCoinTransactions, String> {

}
