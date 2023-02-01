package com.api.stockmanager.models;

import jakarta.persistence.*;
import jakarta.servlet.http.HttpServlet;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

;
@Entity
@Table(name="TB_STOCK")
@ManagedBean(name = "stockProductModelB")
public class StockProductModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//Id gerado de forma automatica AUTO.
    private UUID id;
    @Column(nullable = false, unique = true, length = 10)
    private String productNumber;//numero do produto
    @Column(nullable = false, length = 255)
    private String productName;//nome do produto
    @Column(nullable = false, length = 10)
    private String productMaker;//fabricante do produto
    @Column(nullable = false, length = 10)
    private String productAmount;//quantidade de produto
    @Column(nullable = false, length = 10)
    private String productBalance;//saldo do produto
    @Column(nullable = false)
    private LocalDateTime registrationDate;//data de criacao do produto

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
}
