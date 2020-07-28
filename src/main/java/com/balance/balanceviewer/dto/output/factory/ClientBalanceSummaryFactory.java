package com.balance.balanceviewer.dto.output.factory;

import com.balance.balanceviewer.dto.output.ClientBalanceSummaryResponse;
import com.balance.balanceviewer.logic.AbstractClientBalanceSummaryFactory;
import com.balance.balanceviewer.model.BalanceSummary;
import com.balance.balanceviewer.model.ClientBalanceSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientBalanceSummaryFactory implements AbstractClientBalanceSummaryFactory {

    @Autowired
    ClientInfoFactory clientInfoResponseFactory;

    public ClientBalanceSummary createClientBalanceSummary(BalanceSummary balanceSummary) {
        return ClientBalanceSummaryResponse.builder()
                .clientInfo(clientInfoResponseFactory.createClientInfoResponse(balanceSummary.getClientInfo()))
                .currentBalance(balanceSummary.getCurrentBalance())
                .summaryAccountTurnover(balanceSummary.getSummaryAccountTurnover())
                .summaryIncomes(balanceSummary.getSummaryIncomes())
                .summaryOutcomes(balanceSummary.getSummaryOutcomes())
                .build();
    }
}
