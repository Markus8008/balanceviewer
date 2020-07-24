package com.balance.balanceviewer.dto.input;

import com.balance.balanceviewer.model.Client;
import com.balance.balanceviewer.model.CurrencyType;
import com.balance.balanceviewer.model.Transaction;
import com.balance.balanceviewer.model.TransactionType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class ClientRequest implements Client {

    @JsonProperty("info")
    private ClientInfoRequest clientInfo;

    private BalanceRequest balance;

    private List<TransactionRequest> transactions;

    public List<Transaction> getTransactions() {
        return transactions.stream().map(trans -> new Transaction() {
            @Override
            public BigDecimal getValue() {
                return trans.getValue();
            }

            @Override
            public LocalDate getDate() {
                return trans.getDate();
            }

            @Override
            public CurrencyType getCurrency() {
                return trans.getCurrency();
            }

            @Override
            public TransactionType getType() {
                return trans.getType();
            }

            @Override
            public String getDescription() {
                return trans.getDescription();
            }
        }).collect(Collectors.toList());
    }

}
