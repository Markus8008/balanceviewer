package com.balance.balanceviewer.dto.input;

import com.balance.balanceviewer.model.Balance;
import com.balance.balanceviewer.model.Client;
import com.balance.balanceviewer.model.ClientInfo;
import com.balance.balanceviewer.model.Transaction;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class ClientsRequest {

    @JsonProperty("client")
    List<ClientRequest> clientList;

    public List<Client> getClientList() {
        return clientList.stream().map(client -> new Client() {
            @Override
            public ClientInfo getClientInfo() { return client.getClientInfo(); }
            @Override
            public Balance getBalance() { return client.getBalance(); }
            @Override
            public List<Transaction> getTransactions() { return client.getTransactions(); }
        }).collect(Collectors.toList());
    }
}
