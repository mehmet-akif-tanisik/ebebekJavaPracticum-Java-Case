package com.ecommerce.entity;

import com.ecommerce.entity.Brand;
import com.ecommerce.entity.Category;

public abstract class Product {

    private static int counter = 0;
    private int productId;
    private double unitPrice;
    private double discountRate;
    private int amountOfStock;
    private String productName;
    private Brand brand;
    private Category category;

    public Product() {
        setProductId(counter);
    }

    public Product(double unitPrice, double discountRate, int amountOfStock, String productName, Brand brand, Category category) {
        setProductId(counter);
        this.unitPrice = unitPrice;
        this.discountRate = discountRate;
        this.amountOfStock = amountOfStock;
        this.productName = productName;
        this.brand = brand;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    private void setProductId(int productId) {
        this.productId = productId;
        counter++;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public int getAmountOfStock() {
        return amountOfStock;
    }

    public void setAmountOfStock(int amountOfStock) {
        this.amountOfStock = amountOfStock;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getBrandName() {
        return brand.getBrandName();
    }

    @Override
    public String toString() {
        return String.format("%s %s P.ID: %-3d| P.Name: %-14s| Price: %-8.1f| Discount: %-5.1f| Stock: %-4d| ",
                category,brand,productId,productName,unitPrice,discountRate,amountOfStock);
    }

    public boolean equals(Object original){
        if (original==null){
            return false;
        } else if (getClass() != original.getClass()){
            return false;
        } else {
            Product other = (Product) original;
            return (productId == other.getProductId() &&
                    unitPrice == other.getUnitPrice() &&
                    discountRate == other.getDiscountRate() &&
                    amountOfStock == other.getAmountOfStock() &&
                    productName.equals(other.getProductName()) &&
                    brand.equals(other.getBrand()) &&
                    category.equals(other.getCategory())) ;
        }
    }
}
