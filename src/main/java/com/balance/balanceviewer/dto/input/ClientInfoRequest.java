package com.balance.balanceviewer.dto.input;

import com.balance.balanceviewer.model.ClientInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ClientInfoRequest implements ClientInfo {

    private String name;
    private String surname;
    private String country;
}
