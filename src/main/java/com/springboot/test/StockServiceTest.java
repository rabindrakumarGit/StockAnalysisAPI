package com.springboot.test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import com.springboot.StockService;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StockServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private StockService stockService;

    @BeforeEach
    public void setUp() {
       // MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetStockData() {
        // Mock response from the external API
        String symbol = "AAPL";
        String expectedResponse = "{\"symbol\":\"AAPL\",\"price\":150.0}";

        // Configure mock RestTemplate to return expectedResponse when called
        String apiUrl = "https://api.stock.example";
        when(restTemplate.getForObject(apiUrl + "/" + symbol, String.class))
                .thenReturn(expectedResponse);

        // Call the method under test
        String actualResponse = stockService.getStockData(symbol);

        // Verify that restTemplate.getForObject() was called with the correct URL
        verify(restTemplate, times(1)).getForObject(apiUrl + "/" + symbol, String.class);

        // Verify the returned response
        assertEquals(expectedResponse, actualResponse);
    }
}
