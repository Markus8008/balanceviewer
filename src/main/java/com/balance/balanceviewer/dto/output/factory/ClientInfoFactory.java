package com.balance.balanceviewer.dto.output.factory;

import com.balance.balanceviewer.dto.output.ClientInfoResponse;
import com.balance.balanceviewer.model.ClientInfo;
import org.springframework.stereotype.Component;

@Component
public class ClientInfoFactory {

    public ClientInfo createClientInfoResponse(ClientInfo client) {
        return ClientInfoResponse.builder()
                .name(client.getName())
                .surname(client.getSurname())
                .country(client.getCountry())
                .build();
    }
}
