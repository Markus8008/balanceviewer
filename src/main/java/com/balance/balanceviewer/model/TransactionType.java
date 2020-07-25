package com.balance.balanceviewer.model;

import lombok.Getter;

@Getter
public enum TransactionType {
    OUTCOME("outcome"),
    INCOME("income");

    private String description;

    TransactionType(String description) {
        this.description = description;
    }
}
