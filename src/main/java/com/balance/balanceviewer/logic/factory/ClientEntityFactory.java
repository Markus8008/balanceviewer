package com.balance.balanceviewer.logic.factory;

import com.balance.balanceviewer.model.Client;
import com.balance.balanceviewer.model.ClientInfo;
import com.balance.balanceviewer.persistance.model.ClientEntity;
import org.springframework.stereotype.Component;

@Component
public class ClientEntityFactory {

    public ClientEntity createClientEntity(ClientInfo clientInfo) {
        return ClientEntity.builder()
                .name(clientInfo.getName())
                .surname(clientInfo.getSurname())
                .country(clientInfo.getCountry())
                .build();
    }
}
