package com.balance.balanceviewer.dto.output;

import com.balance.balanceviewer.model.ClientBalanceSummary;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter @Setter
public class BalanceSummaryResponse {
    private List<ClientBalanceSummary> balances;
}
