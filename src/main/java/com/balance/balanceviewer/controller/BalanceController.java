package com.balance.balanceviewer.controller;

import com.balance.balanceviewer.dto.ClientWeb;
import com.balance.balanceviewer.dto.input.ClientsData;
import com.balance.balanceviewer.dto.output.BalanceSummary;
import com.balance.balanceviewer.persistance.model.Client;
import com.balance.balanceviewer.persistance.repository.BalanceRepository;
import com.balance.balanceviewer.persistance.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class BalanceController {

    @Autowired
    BalanceRepository balanceRepository;

    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/balance/getall")
    public Client retriveBalances() {
        return clientRepository.findById(1).get();
    }

    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ClientWeb addEmployee(@RequestBody ClientWeb client) throws Exception
    {
        client.setCountry("Canada");
        return client;
    }

    @PostMapping(path= "/clients", consumes = "application/json", produces = "application/json")
    public BalanceSummary addEmployee(@RequestBody ClientsData dataClients) throws Exception
    {
        return  BalanceSummary.builder()
                .currentBalance(new BigDecimal("123"))
                .summaryAccountTurnover(new BigDecimal("432"))
                .build();
    }
}
