package com.balance.balanceviewer.logic.balancestrategy;

import com.balance.balanceviewer.model.BalanceSummary;
import com.balance.balanceviewer.model.Client;
import com.balance.balanceviewer.model.TransactionType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service(SummarizeBalanceStatelessService.SERVICE_NAME)
public class SummarizeBalanceStatelessService implements SummarizeBalanceStrategy {
    public static final String SERVICE_NAME = "summarizeBalanceStatelessService";

    @Override
    public BalanceSummary getBalanceSummary(Client client, LocalDate balanceDate) {
        return new BalanceSummary() {
            @Override
            public BigDecimal getCurrentBalance() {
                return balanceDate.isBefore(client.getBalance().getDate()) ? null : client.getBalance().getTotal();
            }

            @Override
            public BigDecimal getSummaryAccountTurnover() {
                return getSummaryIncomes().add(getSummaryOutcomes().negate());
            }

            @Override
            public BigDecimal getSummaryIncomes() {
                return client.getTransactions().stream()
                        .filter(trans -> trans.getDate().isAfter(client.getBalance().getDate()))
                        .filter(trans -> !trans.getDate().isAfter(balanceDate))
                        .filter(trans -> trans.getType() == TransactionType.INCOME)
                        .map(trans -> trans.getValue())
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
            }

            @Override
            public BigDecimal getSummaryOutcomes() {
                return client.getTransactions().stream()
                        .filter(trans -> trans.getDate().isAfter(client.getBalance().getDate()))
                        .filter(trans -> !trans.getDate().isAfter(balanceDate))
                        .filter(trans -> trans.getType() == TransactionType.OUTCOME)
                        .map(trans -> trans.getValue())
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
            }

        };
    }
}
