package com.balance.balanceviewer.persistance;

import lombok.Getter;

@Getter
public enum CurrencyType {
    PLN("polski złoty"),
    USD("american dollar"),
    EUR("euro"),
    CHF("frankowicz");

    private String description;

    private CurrencyType(String description) {
        this.description = description;
    }
}
