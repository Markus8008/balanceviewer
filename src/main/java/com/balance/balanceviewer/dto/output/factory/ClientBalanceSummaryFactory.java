package com.balance.balanceviewer.dto.output.factory;

import com.balance.balanceviewer.dto.output.ClientBalanceSummaryResponse;
import com.balance.balanceviewer.logic.SummarizeBalanceService;
import com.balance.balanceviewer.model.BalanceSummary;
import com.balance.balanceviewer.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ClientBalanceSummaryFactory {

    @Autowired
    ClientInfoResponseFactory clientInfoResponseFactory;

    public ClientBalanceSummaryResponse createClientBalanceSummary(Client client, BalanceSummary balanceSummary) {
        return ClientBalanceSummaryResponse.builder()
                .clientInfo(clientInfoResponseFactory.createClientInfoResponse(client.getClientInfo()))
                .currentBalance(balanceSummary.getCurrentBalance())
                .summaryAccountTurnover(balanceSummary.getSummaryAccountTurnover())
                .summaryIncomes(balanceSummary.getSummaryIncomes())
                .summaryOutcomes(balanceSummary.getSummaryOutcomes())
                .build();
    }
}
