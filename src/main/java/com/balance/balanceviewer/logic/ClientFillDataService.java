package com.balance.balanceviewer.logic;

import com.balance.balanceviewer.dto.input.ClientRequest;
import com.balance.balanceviewer.dto.input.ClientsDataRequest;
import com.balance.balanceviewer.logic.factory.ClientEntityFactory;
import com.balance.balanceviewer.persistance.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientFillDataService {

    @Autowired
    private ClientEntityFactory clientEntityFactory;

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public void fillClientData(ClientsDataRequest clientsData) {
        for (ClientRequest client:clientsData.getClients().getClientList()) {
            clientRepository.save(clientEntityFactory.createClientEntity(client.getClientInfo()));
        }
    }
}
