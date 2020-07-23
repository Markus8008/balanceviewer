package com.balance.balanceviewer.persistance;

import lombok.Getter;

@Getter
public enum TransactionType {
    OUTCOME("outcome"),
    INCOME("income");

    private String description;

    private TransactionType(String description) {
        this.description = description;
    }
}
