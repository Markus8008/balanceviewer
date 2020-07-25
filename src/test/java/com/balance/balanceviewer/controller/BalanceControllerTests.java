package com.balance.balanceviewer.controller;

import com.balance.balanceviewer.logic.SummarizeBalanceService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.MOCK)
public class BalanceControllerTests {

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private SummarizeBalanceService summarizeBalanceService;

    @Before
    public void setUp() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }


    @Test
    public void should_return_balance_with_client() throws Exception {
        //String json = mapper.writeValueAsString(ClientsDataRequestCreator.createClientsDataRequestForTest());
        String value = "{\"clients\":{\"client\":[{\"balance\":{\"total\":123.4,\"date\":\"01.05.2020\",\"currency\":\"PLN\"},\"transactions\":[{\"value\":7895.3,\"type\":\"INCOME\",\"currency\":\"PLN\",\"date\":\"05.07.2020\",\"description\":\"wypłata\"},{\"value\":3254.33,\"type\":\"OUTCOME\",\"currency\":\"PLN\",\"date\":\"15.07.2020\",\"description\":\"zakupy\"}],\"info\":{\"name\":\"Mark\",\"surname\":\"Mia\",\"country\":\"USA\"}}]}}";
        mockMvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(value)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.balances[0].currentBalance").value("123,4"))
                .andExpect(jsonPath("$.balances[0].clientInfo.name").value("Mark"));

    }
}
