package com.balance.balanceviewer.dto.output;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class ClientInfoResponse {

    private String name;
    private String surname;
    private String country;
}
