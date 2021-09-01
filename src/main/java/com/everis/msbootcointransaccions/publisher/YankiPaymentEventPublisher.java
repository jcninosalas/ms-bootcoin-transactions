package com.everis.msbootcointransaccions.publisher;

import com.everis.msbootcointransaccions.event.YankiPaymentEvent;
import com.everis.msbootcointransaccions.model.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Sinks;

@Component
@Slf4j
public class YankiPaymentEventPublisher {

    private final Sinks.Many<YankiPaymentEvent> sink;

    @Autowired
    public YankiPaymentEventPublisher(Sinks.Many<YankiPaymentEvent> sink) {
        this.sink = sink;
    }

    public void process(Transaction transaction) {
        var event = YankiPaymentEvent.builder()
                .ammount(transaction.getAmmount())
                .phoneNumber(transaction.getBuyersPhoneNumber())
                .build();
        log.info("Yanki payment event to publish: {}", event.toString());
        sink.emitNext(event, Sinks.EmitFailureHandler.FAIL_FAST);
    }
}
