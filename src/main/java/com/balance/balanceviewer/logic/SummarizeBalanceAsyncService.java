package com.balance.balanceviewer.logic;

import com.balance.balanceviewer.model.BalanceSummary;
import com.balance.balanceviewer.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class SummarizeBalanceAsyncService {

    @Autowired
    @Qualifier(BeanConfiguration.EXECUTOR_SERVICE)
    private ExecutorService executorService;

    private SummarizeBalanceService summarizeBalanceServic;

    public SummarizeBalanceAsyncService(SummarizeBalanceService summarizeBalanceService) {
        this.summarizeBalanceServic = summarizeBalanceService;
    }

    public CompletableFuture<BalanceSummary> balanceSummaryTask(Client client, LocalDate balanceDate) {
        return CompletableFuture.supplyAsync(() -> summarizeBalanceServic.getBalanceSummary(client, balanceDate), executorService);
    }


}

