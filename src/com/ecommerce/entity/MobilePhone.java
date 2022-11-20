package com.ecommerce.entity;

import com.ecommerce.entity.Brand;
import com.ecommerce.entity.Category;

public class MobilePhone extends Product {

    private int memorySize;
    private double screenSize;
    private int batteryCapacity;
    private int ramMemorySize;
    private String color;

    public MobilePhone(){
        super();
    }

    public MobilePhone(double unitPrice, double discountRate, int amountOfStock, String productName,
                       Brand brand, Category category, int memorySize, double screenSize, int batteryCapacity,
                       int ramMemorySize, String color) {
        super(unitPrice, discountRate, amountOfStock, productName, brand, category);
        this.memorySize = memorySize;
        this.screenSize = screenSize;
        this.batteryCapacity = batteryCapacity;
        this.ramMemorySize = ramMemorySize;
        this.color = color;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public int getRamMemorySize() {
        return ramMemorySize;
    }

    public void setRamMemorySize(int ramMemorySize) {
        this.ramMemorySize = ramMemorySize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString()+String.format(" Memory: %-5d| SSize: %-5.1f| Battery: %-5d| RAM: %-2d| Color: %-6s",memorySize,screenSize,batteryCapacity,ramMemorySize,color);
    }


    public boolean equals(Object original){
        if (original==null){
            return false;
        } else if (getClass() != original.getClass()){
            return false;
        } else {
            MobilePhone other = (MobilePhone) original;
            return (super.equals(other) &&
                    memorySize==other.getMemorySize() &&
                    screenSize== other.getScreenSize() &&
                    batteryCapacity == other.getBatteryCapacity() &&
                    ramMemorySize == other.getRamMemorySize() &&
                    color.equals(other.getColor()));
        }
    }
}
