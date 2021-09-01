package com.everis.msbootcointransaccions.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Builder
public class Transaction {
    private BigDecimal ammount;
    private String buyersPhoneNumber;
    private String sellersPhoneNumber;
    private Date createdAt;
    private TransactionType transactionType;
    private PaymentMethod paymentMethod;
}
