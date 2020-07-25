package com.balance.balanceviewer.logic;

import com.balance.balanceviewer.model.BalanceSummary;
import com.balance.balanceviewer.model.Client;

import java.time.LocalDate;

public interface SummarizeBalanceService {
    BalanceSummary getBalanceSummary(Client client, LocalDate balanceDate);
}
