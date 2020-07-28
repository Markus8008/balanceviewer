package com.balance.balanceviewer.logic;

import com.balance.balanceviewer.model.BalanceSummary;
import com.balance.balanceviewer.model.Client;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service
public class SummarizeBalanceAsyncService {

    private ExecutorService executor
            = Executors.newSingleThreadExecutor();

    private SummarizeBalanceService summarizeBalanceServic;

    public SummarizeBalanceAsyncService(SummarizeBalanceService summarizeBalanceService) {
        this.summarizeBalanceServic = summarizeBalanceService;
    }

    public Future<BalanceSummary> balanceSummaryTask(Client client, LocalDate balanceDate) {
        return executor.submit(() -> summarizeBalanceServic.getBalanceSummary(client, balanceDate));
    }
}
