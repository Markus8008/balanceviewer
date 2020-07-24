package com.balance.balanceviewer.model;

import java.util.List;

public interface Client {

    ClientInfo getClientInfo();
    Balance getBalance();
    List<Transaction> getTransactions();
}
