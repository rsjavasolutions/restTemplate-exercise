package com.rs.converter;

import com.rs.converter.model.Rate;
import com.rs.converter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController

public class CurrencyController {

    CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/currencies")
    public List<Rate> getCurrency() throws IOException {
        return currencyService.getCurrency();
    }

    @GetMapping("/currencies/{value}")
    public Double getCourse(@PathVariable String value) throws IOException {
        return currencyService.getCourse(value);
    }

    @GetMapping("/currencies/convert")
    public Double getExchange(@RequestParam Double amount, String from, String to) throws IOException {
        return currencyService.getExchange(amount, from, to);
    }

    @GetMapping("currencies/sale")
    public List<Rate> getSaleCurrency() throws IOException {
        return currencyService.getSaleRateCurrencies();
    }

    @GetMapping("currencies/buy")
    public List<Rate> getBuyCurrency() throws IOException {
        return currencyService.getBuyRateCurrencies();
    }
}