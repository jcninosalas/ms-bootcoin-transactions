package com.everis.msbootcointransaccions.event;

import com.everis.msbootcointransaccions.model.PaymentMethod;
import lombok.Builder;
import lombok.ToString;

import java.math.BigDecimal;

@Builder
@ToString
public class YankiPaymentEvent implements Event{

    private static final String EVENT = "PaymentRequiredEvent";
    private BigDecimal ammount;
    private String phoneNumber;

    @Override
    public String getEvent() {
        return EVENT;
    }
}
