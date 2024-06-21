package com.springboot.test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.springboot.StockController;
import com.springboot.StockService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StockController.class)
@AutoConfigureMockMvc
public class StockControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private StockService stockService;

    @Test
    public void testGetStockData() throws Exception {
        String symbol = "AAPL";
        String mockStockData = "Mock stock data for AAPL";

        // Mock the behavior of StockService.getStockData(symbol)
       // given(stockService.getStockData(symbol)).willReturn(mockStockData);

        // Perform GET request and verify the response
        mockMvc.perform(get("/api/stocks/{symbol}", symbol))
               .andExpect(status().isOk())
               .andExpect(content().string(mockStockData));
    }
}
