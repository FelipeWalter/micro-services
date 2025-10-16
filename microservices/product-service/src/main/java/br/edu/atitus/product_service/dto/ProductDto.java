package br.edu.atitus.product_service.dto;

import java.math.BigDecimal;

public class ProductDto {

    private Long id;
    private String name;
    private BigDecimal price;

    private String toCurrency;
    private Double convertedPrice;
    private String environment;

    public ProductDto() {
    }

    public ProductDto(Long id, String name, BigDecimal price, String toCurrency, Double convertedPrice, String environment) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.toCurrency = toCurrency;
        this.convertedPrice = convertedPrice;
        this.environment = environment;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public Double getConvertedPrice() {
        return convertedPrice;
    }

    public void setConvertedPrice(Double convertedPrice) {
        this.convertedPrice = convertedPrice;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}