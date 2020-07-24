package com.balance.balanceviewer.dto.output;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter @Setter
public class BalanceSummaryResponse {
    private List<ClientBalanceSummaryResponse> balances;
}
