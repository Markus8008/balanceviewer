package com.balance.balanceviewer.dto.input;

import com.balance.balanceviewer.dto.CurrencyDeserializer;
import com.balance.balanceviewer.dto.LocalBigDecimalDeserializer;
import com.balance.balanceviewer.dto.TransactionTypeDeserializer;
import com.balance.balanceviewer.model.CurrencyType;
import com.balance.balanceviewer.model.Transaction;
import com.balance.balanceviewer.model.TransactionType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class TransactionRequest implements Transaction {

    @JsonDeserialize(using = LocalBigDecimalDeserializer.class)
    private BigDecimal value;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate date;

    @JsonDeserialize(using = CurrencyDeserializer.class)
    private CurrencyType currency;

    @JsonDeserialize(using = TransactionTypeDeserializer.class)
    private TransactionType type;

    private String description;
}
