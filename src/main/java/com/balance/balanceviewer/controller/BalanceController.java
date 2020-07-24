package com.balance.balanceviewer.controller;

import com.balance.balanceviewer.dto.input.ClientsDataRequest;
import com.balance.balanceviewer.dto.output.BalanceSummaryResponse;
import com.balance.balanceviewer.dto.output.ClientBalanceSummaryResponse;
import com.balance.balanceviewer.dto.output.factory.ClientBalanceSummaryFactory;
import com.balance.balanceviewer.logic.balancestrategy.SummarizeBalanceStatelessService;
import com.balance.balanceviewer.logic.balancestrategy.SummarizeBalanceStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BalanceController {

    @Autowired
    @Qualifier(SummarizeBalanceStatelessService.SERVICE_NAME)
    private SummarizeBalanceStrategy summarizeBalanceService;

    @Autowired
    private ClientBalanceSummaryFactory clientBalanceSummaryFactory;

    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public BalanceSummaryResponse summarizeBalance(@RequestBody ClientsDataRequest dataClients) throws Exception
    {
        List<ClientBalanceSummaryResponse> clientBalanceSummaryResponseList =
                dataClients.getClients().getClientList().stream().map(client ->
                        clientBalanceSummaryFactory.createClientBalanceSummary(client, summarizeBalanceService, LocalDate.now()))
                        .collect(Collectors.toList());

        return BalanceSummaryResponse.builder()
                .balances(clientBalanceSummaryResponseList)
                .build();
    }
}
