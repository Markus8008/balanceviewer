package com.balance.balanceviewer.model;

import com.balance.balanceviewer.dto.CurrencyDeserializer;
import com.balance.balanceviewer.dto.LocalBigDecimalDeserializer;
import com.balance.balanceviewer.dto.TransactionTypeDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Transaction {

    BigDecimal getValue();
    LocalDate getDate();
    CurrencyType getCurrency();
    TransactionType getType();
    String getDescription();
}
