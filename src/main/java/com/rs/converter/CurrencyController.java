package com.rs.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
    public Double getExchange(@RequestParam Double amount, String from) throws IOException {
        return currencyService.getExchange(amount, from);
    }
}