package com.balance.balanceviewer.dto.output;

import com.balance.balanceviewer.model.ClientInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class ClientInfoResponse implements ClientInfo {

    private String name;
    private String surname;
    private String country;
}
