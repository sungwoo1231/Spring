package com.dw.jdbcapp.dto;

import com.dw.jdbcapp.model.Product;

public class ProductDTO {
    private int productId;
    private String productName;
    private double unitPrice;
    private int stock;
    private double stockValue ;

    public ProductDTO() {
    }


    public ProductDTO(int productId, String productName, double unitPrice, int stock,double stockValue) {
        this.productId = productId;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.stockValue = stockValue;

    }

    public double getStockValue() {
        return stockValue;
    }

    public void setStockValue(double stockValue) {
        this.stockValue = unitPrice * stock;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
    public ProductDTO fromProduct(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(0);
        productDTO.setProductName("");
        productDTO.setUnitPrice(0);
        productDTO.setStock(0);
        productDTO.setStockValue(productDTO.getUnitPrice()*productDTO.getStock());
        return productDTO;
    }
}
