package com.dw.jdbcapp.model;

public class OrderDetail {
    private String orderId;
    private int productNum;
    private double price;
    private int orderQuantity;
    private double discountRate;

    public OrderDetail() {
    }

    public OrderDetail(String orderId, int productNum, double price, int orderQuantity, double discountRate) {
        this.orderId = orderId;
        this.productNum = productNum;
        this.price = price;
        this.orderQuantity = orderQuantity;
        this.discountRate = discountRate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getProductNum() {
        return productNum;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
                "orderId='" + orderId + '\'' +
                ", productNum=" + productNum +
                ", price=" + price +
                ", orderQuantity=" + orderQuantity +
                ", discountRate=" + discountRate +
                '}';
    }
}