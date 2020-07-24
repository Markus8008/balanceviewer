package com.balance.balanceviewer.dto.input;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@NoArgsConstructor
public class Client {
    private ClientInfo info;
    private Balance balance;
    private List<Transaction> transactions;
}
