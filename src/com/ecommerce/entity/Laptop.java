package com.ecommerce.entity;

import com.ecommerce.entity.Brand;
import com.ecommerce.entity.Category;

public class Laptop extends Product {

    private int memorySize;
    private int ramMemorySize;
    private double screenSize;

    public Laptop(){
        super();
    }

    public Laptop(double unitPrice, double discountRate, int amountOfStock, String productName, Brand brand, Category category, int memorySize, int ramMemorySize, double screenSize) {
        super(unitPrice, discountRate, amountOfStock, productName, brand, category);
        this.memorySize = memorySize;
        this.ramMemorySize = ramMemorySize;
        this.screenSize = screenSize;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    public int getRamMemorySize() {
        return ramMemorySize;
    }

    public void setRamMemorySize(int ramMemorySize) {
        this.ramMemorySize = ramMemorySize;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" Memory: %-5d| SSize: %-5.1f| RAM: %-7d",memorySize,screenSize,ramMemorySize);
    }

    public boolean equals(Object original){
        if (original==null){
            return false;
        } else if (getClass() != original.getClass()){
            return false;
        } else {
            Laptop other = (Laptop) original;
            return (super.equals(other) &&
                    memorySize == other.getMemorySize() &&
                    ramMemorySize == other.getRamMemorySize() &&
                    screenSize == other.getScreenSize());
        }
    }
}
