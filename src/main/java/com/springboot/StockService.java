package com.springboot;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StockService {

    @Value("${stock.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    public StockService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getStockData(String symbol) {
        String url = apiUrl + "/" + symbol; // Adjust URL based on your stock API
        return restTemplate.getForObject(url, String.class);
    }
}
