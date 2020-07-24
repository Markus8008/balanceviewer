package com.balance.balanceviewer.dto.output;

import com.balance.balanceviewer.dto.LocalBigDecimalSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Getter @Setter
public class ClientBalanceSummaryResponse {

    @JsonSerialize(using = LocalBigDecimalSerializer.class)
    private BigDecimal currentBalance;

    @JsonSerialize(using = LocalBigDecimalSerializer.class)
    private BigDecimal summaryAccountTurnover;

    @JsonSerialize(using = LocalBigDecimalSerializer.class)
    private BigDecimal summaryIncomes;

    @JsonSerialize(using = LocalBigDecimalSerializer.class)
    private BigDecimal summaryOutcomes;

    private ClientInfoResponse clientInfo;
}
