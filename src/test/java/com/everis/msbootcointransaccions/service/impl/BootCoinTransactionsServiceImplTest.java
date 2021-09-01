package com.everis.msbootcointransaccions.service.impl;

import com.everis.msbootcointransaccions.repository.BootCoinTransactionsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

class BootCoinTransactionsServiceImplTest {

    @MockBean
    private BootCoinTransactionsRepository repository;

    @Test
    void transaction() {

    }
}