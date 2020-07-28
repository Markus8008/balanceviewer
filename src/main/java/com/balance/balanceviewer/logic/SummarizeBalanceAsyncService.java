package com.balance.balanceviewer.logic;

import com.balance.balanceviewer.model.BalanceSummary;
import com.balance.balanceviewer.model.Client;
import com.balance.balanceviewer.model.ClientBalanceSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;

@Service
public class SummarizeBalanceAsyncService {

    @Autowired
    @Qualifier(BeanConfiguration.EXECUTOR_SERVICE)
    private ExecutorService executorService;

    private SummarizeBalanceService summarizeBalanceServic;

    public SummarizeBalanceAsyncService(SummarizeBalanceService summarizeBalanceService) {
        this.summarizeBalanceServic = summarizeBalanceService;
    }

    private CompletableFuture<BalanceSummary> balanceSummaryTask(Client client, LocalDate balanceDate) {
        return CompletableFuture.supplyAsync(() -> summarizeBalanceServic.getBalanceSummary(client, balanceDate), executorService);
    }

    public List<ClientBalanceSummary> executeAsyncTask(List<Client> clients, AbstractClientBalanceSummaryFactory clientBalanceSummaryFactory) {
        List<CompletableFuture<BalanceSummary>> listBalanceSummary = clients.stream()
                .map(client -> balanceSummaryTask(client, LocalDate.now()))
                .collect(Collectors.toList());

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(listBalanceSummary.toArray(new CompletableFuture[listBalanceSummary.size()]));

        CompletableFuture<List<BalanceSummary>> allBalanceSummaryFuture = allFutures.thenApply(v -> listBalanceSummary.stream()
                .map(balanceSummaryFuture -> balanceSummaryFuture.join())
                .collect(Collectors.toList()));

        List<ClientBalanceSummary> clientBalanceSummaryResponseList = new ArrayList<>();
        allBalanceSummaryFuture.thenApply(balanceSummaries -> balanceSummaries.stream().map(balanceSummary
                -> clientBalanceSummaryResponseList.add(clientBalanceSummaryFactory.createClientBalanceSummary(balanceSummary))).collect(Collectors.toList()));


        return clientBalanceSummaryResponseList;
    }

}

