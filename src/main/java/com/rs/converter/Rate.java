package com.rs.converter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Rate {

    @JsonProperty("currency")
    private String currency;
    @JsonProperty("code")
    private String code;
    @JsonProperty("mid")
    private Double mid;

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Rate withNo(String no) {
        this.currency = no;
        return this;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    public Rate withEffectiveDate(String effectiveDate) {
        this.code = effectiveDate;
        return this;
    }

    @JsonProperty("mid")
    public Double getMid() {
        return mid;
    }

    @JsonProperty("mid")
    public void setMid(Double mid) {
        this.mid = mid;
    }

    public Rate withMid(Double mid) {
        this.mid = mid;
        return this;
    }
}