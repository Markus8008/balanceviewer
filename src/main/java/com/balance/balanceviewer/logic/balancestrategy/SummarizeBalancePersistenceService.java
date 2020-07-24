package com.balance.balanceviewer.logic.balancestrategy;

import com.balance.balanceviewer.model.BalanceSummary;
import com.balance.balanceviewer.model.Client;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service(SummarizeBalancePersistenceService.SERVICE_NAME)
public class SummarizeBalancePersistenceService implements SummarizeBalanceStrategy {
    public static final String SERVICE_NAME = "summarizeBalancePersistenceService";

    @Override
    public BalanceSummary getBalanceSummary(Client client, LocalDate balanceDate) {
        throw new RuntimeException("Not implemented yet");
    }
}
