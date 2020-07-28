package com.balance.balanceviewer.model;

import java.math.BigDecimal;

public interface ClientBalanceSummary {

    BigDecimal getCurrentBalance();

    BigDecimal getSummaryAccountTurnover();

    BigDecimal getSummaryIncomes();

    BigDecimal getSummaryOutcomes();

    ClientInfo getClientInfo();
}
