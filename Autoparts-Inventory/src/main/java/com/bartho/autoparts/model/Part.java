package com.bartho.autoparts.model;

import jakarta.persistence.*;

@Entity
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private String code;
    private Double price;
    private Integer quantity;

    public Part() {
    }

    public Long getId(){
        return id;
    }
    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getCode() {
        return code;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
