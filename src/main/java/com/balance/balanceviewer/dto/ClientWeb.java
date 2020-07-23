package com.balance.balanceviewer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter @Setter
@AllArgsConstructor
public class ClientWeb {

    private String name;
    private String surname;
    private String country;

}
