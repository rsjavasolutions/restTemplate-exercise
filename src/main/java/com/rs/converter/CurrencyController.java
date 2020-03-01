package com.rs.converter;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@RestController

public class CurrencyController {

    @GetMapping("/currencies")
    public List<Rate> getCurrency() throws IOException {
        String url = "https://api.nbp.pl/api/exchangerates/tables/A/?format=json";
        RestTemplate template = new RestTemplate();
        List<Currency> currencies = template.exchange(url,
                HttpMethod.GET, HttpEntity.EMPTY,
                new ParameterizedTypeReference<List<Currency>>() {
                }).getBody();
        return currencies.get(0).getRates();
    }

    @GetMapping("/currencies/{value}")

    public Double getCourse(@PathVariable String value) throws IOException {
        String val = value.toUpperCase();
        String url = "https://api.nbp.pl/api/exchangerates/rates/A/" + val + "?format=json";
        RestTemplate template = new RestTemplate();
        Currency currencies = template.exchange(url,
                HttpMethod.GET, HttpEntity.EMPTY,
                new ParameterizedTypeReference<Currency>() {
                }).getBody();
        return currencies.getRates().get(0).getMid();
    }

}
