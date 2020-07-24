package com.balance.balanceviewer.dto.output;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Getter @Setter
public class BalanceSummary {

    private BigDecimal currentBalance;
    private BigDecimal summaryAccountTurnover;
    private BigDecimal summaryIncomes;
    private BigDecimal summaryOutcomes;

}
