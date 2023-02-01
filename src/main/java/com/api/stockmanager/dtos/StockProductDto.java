package com.api.stockmanager.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class StockProductDto {

    @NotBlank
    private String productNumber;//numero do produto
    @NotBlank
    @Size(max = 50)
    private String productName;//nome do produto
    @NotBlank
    private String productMaker;//fabricante do produto
    @NotBlank
    private String productAmount;//quantidade de produto
    @NotBlank
    private String productBalance;//saldo do produto


    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductMaker() {
        return productMaker;
    }

    public void setProductMaker(String productMaker) {
        this.productMaker = productMaker;
    }

    public String getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(String productAmount) {
        this.productAmount = productAmount;
    }

    public String getProductBalance() {
        return productBalance;
    }

    public void setProductBalance(String productBalance) {
        this.productBalance = productBalance;
    }
}
