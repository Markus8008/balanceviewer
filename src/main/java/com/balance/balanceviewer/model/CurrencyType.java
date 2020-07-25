package com.balance.balanceviewer.model;

import lombok.Getter;

@Getter
public enum CurrencyType {
    PLN("polski złoty"),
    USD("american dollar"),
    EUR("euro"),
    CHF("frankowicz");

    private String description;

    CurrencyType(String description) {
        this.description = description;
    }
}
