package com.balance.balanceviewer.controller;

import com.balance.balanceviewer.dto.input.ClientsDataRequest;
import com.balance.balanceviewer.dto.output.BalanceSummaryResponse;
import com.balance.balanceviewer.dto.output.ClientBalanceSummaryResponse;
import com.balance.balanceviewer.dto.output.factory.ClientBalanceSummaryFactory;
import com.balance.balanceviewer.logic.SummarizeBalanceAsyncService;
import com.balance.balanceviewer.logic.SummarizeBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@RestController
public class BalanceController {

    @Autowired
    private SummarizeBalanceService summarizeBalanceService;

    @Autowired
    private SummarizeBalanceAsyncService summarizeBalanceAsyncService;

    @Autowired
    private ClientBalanceSummaryFactory clientBalanceSummaryFactory;

    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public BalanceSummaryResponse summarizeBalance(@RequestBody ClientsDataRequest dataClients)
    {
        List<ClientBalanceSummaryResponse> clientBalanceSummaryResponseList =
                dataClients.getClients().getClientList().stream().map(client ->
                        clientBalanceSummaryFactory.createClientBalanceSummary(client, summarizeBalanceService.getBalanceSummary(client, LocalDate.now())))
                        .collect(Collectors.toList());

        return BalanceSummaryResponse.builder()
                .balances(clientBalanceSummaryResponseList)
                .build();
    }

    @PostMapping(path= "/async", consumes = "application/json", produces = "application/json")
    public BalanceSummaryResponse summarizeBalanceAsync(@RequestBody ClientsDataRequest dataClients)
    {
        List<ClientBalanceSummaryResponse> clientBalanceSummaryResponseList =
                dataClients.getClients().getClientList().stream().map(client ->
                {
                    try {
                        return clientBalanceSummaryFactory.createClientBalanceSummary(client,
                                summarizeBalanceAsyncService.balanceSummaryTask(client, LocalDate.now()).get());
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                }).collect(Collectors.toList());

        return BalanceSummaryResponse.builder()
                .balances(clientBalanceSummaryResponseList)
                .build();
    }
}
