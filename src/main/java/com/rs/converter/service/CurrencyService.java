package com.rs.converter.service;

import com.rs.converter.model.Currency;
import com.rs.converter.model.Rate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyService {

    public List<Rate> getCurrency() throws IOException {
        String url = "https://api.nbp.pl/api/exchangerates/tables/A/?format=json";
        RestTemplate template = new RestTemplate();
        List<Currency> currencies = template.exchange(url,
                HttpMethod.GET, HttpEntity.EMPTY,
                new ParameterizedTypeReference<List<Currency>>() {
                }).getBody();
        return currencies.get(0).getRates();

    }

    public List<Rate> getSaleRateCurrencies() throws IOException {
        List<Rate> currenciesMinusMargin = new ArrayList<>();

        for (Rate originRate : getCurrency()) {
            Rate rate = new Rate();
            rate.setCurrency(originRate.getCurrency());
            rate.setCode(originRate.getCode());
            rate.setMid(originRate.getMid() * 0.98);
            currenciesMinusMargin.add(rate);
        }
        return currenciesMinusMargin;
    }

    public List<Rate> getBuyRateCurrencies() throws IOException {
        List<Rate> currenciesMinusMargin = new ArrayList<>();

        for (Rate originRate : getCurrency()) {
            Rate rate = new Rate();
            rate.setCurrency(originRate.getCurrency());
            rate.setCode(originRate.getCode());
            rate.setMid(originRate.getMid() * 1.03);
            currenciesMinusMargin.add(rate);
        }
        return currenciesMinusMargin;
    }

    public Double getCourse(String value) throws IOException {
        if (value.equalsIgnoreCase("PLN")) {
            return 1.0;
        }
        String val = value.toUpperCase();
        String url = "https://api.nbp.pl/api/exchangerates/rates/A/" + val + "?format=json";
        RestTemplate template = new RestTemplate();
        Currency currencies = template.exchange(url,
                HttpMethod.GET, HttpEntity.EMPTY,
                new ParameterizedTypeReference<Currency>() {
                }).getBody();

        return currencies.getRates().get(0).getMid();
    }

    public Double getExchange(Double amount, String from, String to) throws IOException {
        double fromCurrency = getCourse(from);
        double toCurrency = getCourse(to);
        return (fromCurrency / toCurrency) * amount;
    }
}