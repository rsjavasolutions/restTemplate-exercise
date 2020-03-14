package com.rs.converter;

import com.rs.converter.model.CurrencyConverter;
import com.rs.converter.service.CurrencyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class ConverterApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(ConverterApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        CurrencyConverter converter = new CurrencyConverter();
        System.out.println(converter.showConverterStatus());
    }
}
