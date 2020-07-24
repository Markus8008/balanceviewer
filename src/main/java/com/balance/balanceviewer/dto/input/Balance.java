package com.balance.balanceviewer.dto.input;

import com.balance.balanceviewer.dto.LocalBigDecimalDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class Balance {

    @JsonDeserialize(using = LocalBigDecimalDeserializer.class)
    private BigDecimal total;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate date;

    private String currency;
}
