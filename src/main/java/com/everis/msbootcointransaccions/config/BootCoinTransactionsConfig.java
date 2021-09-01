package com.everis.msbootcointransaccions.config;

import com.everis.msbootcointransaccions.consumer.EventConsumer;
import com.everis.msbootcointransaccions.event.BootCoinAccountCreatedEvent;
import com.everis.msbootcointransaccions.event.YankiPaymentEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class BootCoinTransactionsConfig {

    //BootCoinAccountCreatedEvent consumer config
    private final EventConsumer<BootCoinAccountCreatedEvent> accountCreatedEventConsumer;

    @Autowired
    public BootCoinTransactionsConfig(EventConsumer<BootCoinAccountCreatedEvent> accountCreatedEventConsumer) {
        this.accountCreatedEventConsumer = accountCreatedEventConsumer;
    }

    @Bean
    public Consumer<BootCoinAccountCreatedEvent> accountCreatedEventConsumer() {
        return accountCreatedEventConsumer::consumeEvent;
    }

    //YankiPaymentEventPublisherConfig
    @Bean
    public Supplier<Flux<YankiPaymentEvent>> yankiPaymentEventPublisher(
            Sinks.Many<YankiPaymentEvent> publisher) {
        return publisher::asFlux;
    }

    @Bean
    Sinks.Many<YankiPaymentEvent> sink() {
        return Sinks.many()
                .multicast()
                .directBestEffort();
    }
}
