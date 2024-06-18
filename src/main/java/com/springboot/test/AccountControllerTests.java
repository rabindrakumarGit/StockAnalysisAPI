package com.springboot.test;

import java.util.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.springboot.Account;
import com.springboot.AccountController;

//@ExtendWith(MockitoExtension.class)
public class AccountControllerTests {

    @InjectMocks
    private AccountController accountController;

    
    @Test
    public void testGetBalance() throws Exception {
        // Mocking behavior of AccountService
       // when(accountService.getBalance(anyString())).thenReturn(25000.0);

        // MockMvc setup
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();

        // Perform GET request and verify the response
        mockMvc.perform(MockMvcRequestBuilders.get("/mybal/{accno}", "123")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("25000.0")); // Assuming response is text representation of balance
    }

    @Test
    public void testGetAllCounts() throws Exception {
        // Mocking behavior of AccountService
        List<Account> mockAccounts = Arrays.asList(
                new Account(101, "SA", "B99", 19000.0),
                new Account(102, "SA", "B99", 29000.0),
                new Account(103, "SA", "B99", 29000.0)
        );
        //when(accountService.getAllAccounts()).thenReturn(mockAccounts);

        // MockMvc setup
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();

        // Perform GET request and verify the response
        mockMvc.perform(MockMvcRequestBuilders.get("/myaccounts")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3)); // Assuming it returns 3 accounts
    }

    @Test
    public void testAddAccount() throws Exception {
        // Mocking behavior of AccountService
        Account mockAccount = new Account(123, "SA", "B99", 25000.0); // Mocked account with accno 123
       // when(accountService.addAccount(any(Account.class))).thenReturn(mockAccount);

        // MockMvc setup
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();

        // Create a JSON representation of the account to be added
        String jsonAccount = "{\"accno\":null,\"type\":\"SA\",\"branch\":\"B99\",\"balance\":25000.0}";

        // Perform POST request and verify the response
        mockMvc.perform(MockMvcRequestBuilders.post("/addAccount")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonAccount))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.accno").value(123)); // Assuming it returns the added account with accno 123
    }
}
