package com.rs.converter.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CurrencyConverter {

    private Map<Code,Double> codeToAmount;

    public CurrencyConverter() {
        codeToAmount = new HashMap<>();
        codeToAmount.put(Code.CHF,10_000d);
        codeToAmount.put(Code.EUR,10_000d);
        codeToAmount.put(Code.USD,10_000d);
        codeToAmount.put(Code.PLN,10_000d);
        codeToAmount.put(Code.HUF,10_000d);
    }

    public Map<Code, Double> showConverterStatus() {
        return codeToAmount;
    }

    public void setConverterStatus(Map<Code, Double> codeToAmount) {
        this.codeToAmount = codeToAmount;
    }
}
