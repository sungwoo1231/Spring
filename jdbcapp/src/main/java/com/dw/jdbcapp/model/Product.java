package com.dw.jdbcapp.model;

public class Product {
    private int productNumber;
    private String productName;
    private String packagingUnit;
    private double unitPrice;
    private int stock;

    public Product() {
    }

    public Product(int productNumber, String productName, String packagingUnit, double unitPrice, int stock) {
        this.productNumber = productNumber;
        this.productName = productName;
        this.packagingUnit = packagingUnit;
        this.unitPrice = unitPrice;
        this.stock = stock;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPackagingUnit() {
        return packagingUnit;
    }

    public void setPackagingUnit(String packagingUnit) {
        this.packagingUnit = packagingUnit;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productNumber=" + productNumber +
                ", productName='" + productName + '\'' +
                ", packagingUnit='" + packagingUnit + '\'' +
                ", unitPrice=" + unitPrice +
                ", stock=" + stock +
                '}';
    }
}
