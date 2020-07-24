package com.balance.balanceviewer.model;

import java.util.List;

public interface Account {

    String getNrb();
    List<Balance> getBalanes();
    List<Transaction> getTransaction();
}
