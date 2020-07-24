package com.balance.balanceviewer.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Balance {

    BigDecimal getTotal();
    LocalDate getDate();
    CurrencyType getCurrency();

}
