package com.balance.balanceviewer.dto.output.factory;

import com.balance.balanceviewer.dto.output.ClientBalanceSummaryResponse;
import com.balance.balanceviewer.logic.balancestrategy.SummarizeBalanceStrategy;
import com.balance.balanceviewer.model.BalanceSummary;
import com.balance.balanceviewer.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ClientBalanceSummaryFactory {

    @Autowired
    ClientInfoResponseFactory clientInfoResponseFactory;

    public ClientBalanceSummaryResponse createClientBalanceSummary(Client client, SummarizeBalanceStrategy strategy, LocalDate balanceDate) {
        BalanceSummary balanceSummary = strategy.getBalanceSummary(client, balanceDate);
        return ClientBalanceSummaryResponse.builder()
                .clientInfo(clientInfoResponseFactory.createClientInfoResponse(client.getClientInfo()))
                .currentBalance(balanceSummary.getCurrentBalance())
                .summaryAccountTurnover(balanceSummary.getSummaryAccountTurnover())
                .summaryIncomes(balanceSummary.getSummaryIncomes())
                .summaryOutcomes(balanceSummary.getSummaryOutcomes())
                .build();
    }
}
