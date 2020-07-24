package com.balance.balanceviewer.logic.factory;

import com.balance.balanceviewer.model.Balance;
import com.balance.balanceviewer.persistance.model.BalanceEntity;
import org.springframework.stereotype.Component;

@Component
public class BalanceEntityFactory {

    public BalanceEntity createBalance(Balance balance) {
        return BalanceEntity.builder()
                .currency(balance.getCurrency())
                .total(balance.getTotal())
                .date(balance.getDate())
                .build();
    }
}
