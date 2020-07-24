package com.balance.balanceviewer.dto.input;

import com.balance.balanceviewer.model.ClientInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class ClientInfoRequest implements ClientInfo {

    private String name;
    private String surname;
    private String country;
}
