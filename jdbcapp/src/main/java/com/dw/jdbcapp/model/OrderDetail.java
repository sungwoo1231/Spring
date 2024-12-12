package com.dw.jdbcapp.model;

public class OrderDetail  {
    private String orderNumber;
    private int productNumber;
    private double unitPrice;
    private int orderQuantity;
    private double discountRate;

    public OrderDetail() {
    }

    public OrderDetail(String orderNumber, int productNumber, double unitPrice, int orderQuantity, double discountRate) {
        this.orderNumber = orderNumber;
        this.productNumber = productNumber;
        this.unitPrice = unitPrice;
        this.orderQuantity = orderQuantity;
        this.discountRate = discountRate;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderNumber='" + orderNumber + '\'' +
                ", productNumber=" + productNumber +
                ", unitPrice=" + unitPrice +
                ", orderQuantity=" + orderQuantity +
                ", discountRate=" + discountRate +
                '}';
    }
}
