package com.balance.balanceviewer.model;

import java.math.BigDecimal;

public interface BalanceSummary {

    BigDecimal getCurrentBalance();
    BigDecimal getSummaryAccountTurnover();
    BigDecimal getSummaryIncomes();
    BigDecimal getSummaryOutcomes();
}
