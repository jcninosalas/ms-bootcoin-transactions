package com.everis.msbootcointransaccions.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

@Document
@Getter
@Setter
@Builder
public class BootCoinTransactions {
    @Id
    private String id;
    @NotNull
    private String phoneNumber;
    @NotNull
    private BigDecimal balance;
    @NotNull
    private String accountId;
    private ArrayList<Transaction> transactions;
    @NotNull
    private Date createdAt;
    private Date modifiedAt;
}
