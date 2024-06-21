package com.springboot;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/stocks")
@Api(tags = "Stock API")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/{symbol}")
    @ApiOperation(value = "Get stock data by symbol", notes = "Returns stock data for the given symbol")
    public String getStockData(
            @ApiParam(value = "Stock symbol", required = true) @PathVariable String symbol) {
        return stockService.getStockData(symbol);
    }
}
