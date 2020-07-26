package com.balance.balanceviewer.controller;

import com.balance.balanceviewer.logic.SummarizeBalanceService;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(Parameterized.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class BalanceControllerTests {

    private String inputJson;
    private List expectResult;

    @ClassRule
    public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();
    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private SummarizeBalanceService summarizeBalanceService;

    @Before
    public void setUp() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    public BalanceControllerTests(String inputJson, List expectResult) {
        this.inputJson = inputJson;
        this.expectResult = expectResult;
    }

    @Parameterized.Parameters
    public static Collection inputJsonList() {
        return Arrays.asList(new Object[][] {
                { "{\"clients\":{\"client\":[{\"balance\":{\"total\":\"123,4\",\"date\":\"01.05.1234\",\"currency\":\"PLN\"},\"transactions\":[{\"value\":7895.3,\"type\":\"income\",\"currency\":\"PLN\",\"date\":\"05.07.1234\",\"description\":\"wypłata\"},{\"value\":3254.33,\"type\":\"outcome\",\"currency\":\"PLN\",\"date\":\"15.07.1234\",\"description\":\"zakupy\"}],\"info\":{\"name\":\"Mark\",\"surname\":\"Mia\",\"country\":\"USA\"}}]}}",
                        Lists.list("123,4", "4640,97", "7895,3", "3254,33", "Mark", "Mia", "USA") },
                { "{\"clients\":{\"client\":[{\"balance\":{\"total\":\"1234,78\",\"date\":\"01.05.1977\",\"currency\":\"PLN\"},\"transactions\":[{\"value\":7895.3,\"type\":\"INCOME\",\"currency\":\"PLN\",\"date\":\"05.07.1977\",\"description\":\"wypłata\"},{\"value\":33254.33,\"type\":\"OUTCOME\",\"currency\":\"PLN\",\"date\":\"15.07.1977\",\"description\":\"zakupy\"}],\"info\":{\"name\":\"Peter\",\"surname\":\"Klon\",\"country\":\"Portugal\"}}]}}",
                        Lists.list("1234,78", "-25359,03", "7895,3", "33254,33", "Peter", "Klon", "Portugal") },
                { "{\"clients\":{\"client\":[{\"balance\":{\"total\":-1254.65,\"date\":\"23.05.1980\",\"currency\":\"PLN\"},\"transactions\":[{\"value\":7895.3,\"type\":\"INCOME\",\"currency\":\"PLN\",\"date\":\"05.05.1980\",\"description\":\"wypłata\"},{\"value\":3254.33,\"type\":\"OUTCOME\",\"currency\":\"PLN\",\"date\":\"15.04.1980\",\"description\":\"zakupy\"}],\"info\":{\"name\":\"Dan\",\"surname\":\"Fan\"}}]}}",
                        Lists.list("-1254,65", "0", "0", "0", "Dan", "Fan", null) }
        });
    }

    @Test
    public void should_return_balance_with_client() throws Exception {
        mockMvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(inputJson)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.balances[0].currentBalance").value(expectResult.get(0)))
                .andExpect(jsonPath("$.balances[0].summaryAccountTurnover").value(expectResult.get(1)))
                .andExpect(jsonPath("$.balances[0].summaryIncomes").value(expectResult.get(2)))
                .andExpect(jsonPath("$.balances[0].summaryOutcomes").value(expectResult.get(3)))
                .andExpect(jsonPath("$.balances[0].clientInfo.name").value(expectResult.get(4)))
                .andExpect(jsonPath("$.balances[0].clientInfo.surname").value(expectResult.get(5)))
                .andExpect(jsonPath("$.balances[0].clientInfo.country").value(expectResult.get(6)));
    }
}
