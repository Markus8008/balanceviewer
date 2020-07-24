package com.balance.balanceviewer.logic.balancestrategy;

import com.balance.balanceviewer.model.BalanceSummary;
import com.balance.balanceviewer.model.Client;

import java.time.LocalDate;

public interface SummarizeBalanceStrategy {
    BalanceSummary getBalanceSummary(Client client, LocalDate balanceDate);
}
