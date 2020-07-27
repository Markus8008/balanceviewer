package com.balance.balanceviewer.logic;

import com.balance.balanceviewer.model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SummarizeBalanceStatelessServiceTest {

    @Mock private Client client;
    @Mock private Balance balance;
    @Mock private Transaction transaction1, transaction2;

    @InjectMocks
    private SummarizeBalanceStatelessService summarizeBalanceStatelessService;

    @Before
    public void initAssumptions() {
        //Balance assumptions
        when(client.getBalance()).thenReturn(balance);
        when(balance.getDate()).thenReturn(LocalDate.of(2020, 05, 01));
        when(balance.getTotal()).thenReturn(new BigDecimal("123.4"));

        //Transacions assumptions
        when(client.getTransactions()).thenReturn(Arrays.asList(transaction1, transaction2));

        when(transaction1.getDate()).thenReturn(LocalDate.of(2020, 05, 02));
        when(transaction1.getValue()).thenReturn(new BigDecimal("12.3"));
        when(transaction1.getType()).thenReturn(TransactionType.INCOME);

        when(transaction2.getDate()).thenReturn(LocalDate.of(2020, 05, 04));
        when(transaction2.getValue()).thenReturn(new BigDecimal("6.87"));
        when(transaction2.getType()).thenReturn(TransactionType.OUTCOME);
    }

    @Test
    public void should_return_null_balance_for_request_date_before_balance_date() {
        //given
        LocalDate requestDate = LocalDate.of(2020, 04, 06);
        //when
        BalanceSummary balanceSummary = summarizeBalanceStatelessService.getBalanceSummary(client, requestDate);
        //then
        assertNull(balanceSummary.getCurrentBalance());
        assertEquals(BigDecimal.ZERO, balanceSummary.getSummaryIncomes());
        assertEquals(BigDecimal.ZERO, balanceSummary.getSummaryOutcomes());
        assertEquals(BigDecimal.ZERO, balanceSummary.getSummaryAccountTurnover());
    }

    @Test
    public void should_return_balance_for_request_date_equals_balance_date_with_transactions_after_request_date() {
        //given
        LocalDate requestDate = LocalDate.of(2020, 05, 01);
        //when
        BalanceSummary balanceSummary = summarizeBalanceStatelessService.getBalanceSummary(client, requestDate);
        //then
        assertEquals(new BigDecimal("123.4"), balanceSummary.getCurrentBalance());
        assertEquals(BigDecimal.ZERO, balanceSummary.getSummaryIncomes());
        assertEquals(BigDecimal.ZERO, balanceSummary.getSummaryOutcomes());
        assertEquals(BigDecimal.ZERO, balanceSummary.getSummaryAccountTurnover());
    }

    @Test
    public void should_return_summarized_all_transactions_for_request_date_after_balance_date() {
        //given
        LocalDate requestDate = LocalDate.of(2020, 05, 06);
        //when
        BalanceSummary balanceSummary = summarizeBalanceStatelessService.getBalanceSummary(client, requestDate);
        //then
        assertEquals(new BigDecimal("123.4"), balanceSummary.getCurrentBalance());
        assertEquals(new BigDecimal("12.3"), balanceSummary.getSummaryIncomes());
        assertEquals(new BigDecimal("6.87"), balanceSummary.getSummaryOutcomes());
        assertEquals(new BigDecimal("5.43"), balanceSummary.getSummaryAccountTurnover());
    }

    @Test
    public void should_return_summarized_income_transaction_for_request_date_after_balance_date() {
        //given
        LocalDate requestDate = LocalDate.of(2020, 05, 02);
        //when
        BalanceSummary balanceSummary = summarizeBalanceStatelessService.getBalanceSummary(client, requestDate);
        //then
        assertEquals(new BigDecimal("123.4"), balanceSummary.getCurrentBalance());
        assertEquals(new BigDecimal("12.3"), balanceSummary.getSummaryIncomes());
        assertEquals(BigDecimal.ZERO, balanceSummary.getSummaryOutcomes());
        assertEquals(new BigDecimal("12.3"), balanceSummary.getSummaryAccountTurnover());
    }
}
