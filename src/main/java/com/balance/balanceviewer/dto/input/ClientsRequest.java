package com.balance.balanceviewer.dto.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class ClientsRequest {

    @JsonProperty("client")
    List<ClientRequest> clientList;
}
