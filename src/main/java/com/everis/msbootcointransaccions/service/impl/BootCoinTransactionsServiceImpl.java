package com.everis.msbootcointransaccions.service.impl;

import com.everis.msbootcointransaccions.model.BootCoinTransactions;
import com.everis.msbootcointransaccions.model.Transaction;
import com.everis.msbootcointransaccions.publisher.YankiPaymentEventPublisher;
import com.everis.msbootcointransaccions.repository.BootCoinTransactionsRepository;
import com.everis.msbootcointransaccions.service.BootCoinTransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;

public class BootCoinTransactionsServiceImpl implements BootCoinTransactionsService {

    @Autowired
    private BootCoinTransactionsRepository repository;

    @Autowired
    private YankiPaymentEventPublisher publisher;

    @Override
    public Mono<Object> transaction(Transaction transaction) {
        return repository.findByPhoneNumber(transaction.getSellersPhoneNumber())
                .flatMap(transactions -> proccesTransaction.apply(transactions, transaction));
    }

    private final BiFunction<BootCoinTransactions, Transaction, Mono<String>> proccesTransaction =
            (transactions, transaction) -> {
        if (transactions.getBalance().compareTo(transaction.getAmmount()) < 0)
            return Mono.just("Saldo insuficiente para procesar la transaccion");
        publisher.process(transaction);
        return Mono.just("Transaccion en proceso");
    };
}
