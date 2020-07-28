package com.balance.balanceviewer.logic;

import com.balance.balanceviewer.model.BalanceSummary;
import com.balance.balanceviewer.model.ClientBalanceSummary;

public interface AbstractClientBalanceSummaryFactory {

    ClientBalanceSummary createClientBalanceSummary(BalanceSummary balanceSummary);
}
