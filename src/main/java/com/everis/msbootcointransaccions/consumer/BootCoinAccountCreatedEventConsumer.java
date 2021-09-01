package com.everis.msbootcointransaccions.consumer;

import com.everis.msbootcointransaccions.event.BootCoinAccountCreatedEvent;
import com.everis.msbootcointransaccions.model.BootCoinTransactions;
import com.everis.msbootcointransaccions.repository.BootCoinTransactionsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.Instant;

/*
Aqui se consume el evento publicado por el ms de creacion de cuentas
asi al crear una cuenta un registro de transacciones es creado tambien
 */
@Component
@Slf4j
public class BootCoinAccountCreatedEventConsumer implements EventConsumer<BootCoinAccountCreatedEvent>{

    @Autowired
    private BootCoinTransactionsRepository repository;


    @Override
    public void consumeEvent(BootCoinAccountCreatedEvent event) {
        log.info("BootCoin account created event : {}", event.toString());
        var bootcoinTransactions = BootCoinTransactions.builder()
                .accountId(event.getAccountId())
                .createdAt(Date.from(Instant.now()))
                .phoneNumber(event.getPhoneNumber())
                .balance(BigDecimal.valueOf(20)) // Defini que cada cuenta puede iniciar con 20 boot-coins de regalo!
                .build();
        repository.save(bootcoinTransactions).subscribe();
    }
}