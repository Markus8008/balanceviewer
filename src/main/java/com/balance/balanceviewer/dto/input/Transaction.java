package com.balance.balanceviewer.dto.input;

import com.balance.balanceviewer.controller.LocalBigDecimalDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class Transaction {

    @JsonDeserialize(using = LocalBigDecimalDeserializer.class)
    private BigDecimal value;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate date;

    private String currency;
    private String description;
    private String type;

}
