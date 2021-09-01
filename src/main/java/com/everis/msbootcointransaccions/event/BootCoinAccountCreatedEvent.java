package com.everis.msbootcointransaccions.event;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BootCoinAccountCreatedEvent implements  Event{

    private static final String EVENT = "BootCoinAccountCreated";
    private String accountId;
    private String phoneNumber;

    @Override
    public String getEvent() {
        return null;
    }
}
