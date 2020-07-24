package com.balance.balanceviewer.dto.input;

import com.balance.balanceviewer.dto.input.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@NoArgsConstructor
public class Clients {
    List<Client> client;
}
