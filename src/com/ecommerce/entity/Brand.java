package com.ecommerce.entity;

public class Brand {

    private static int brandCounter = 0;
    private int brandId;
    private String brandName;


    public Brand(String brandName) {
        this.brandName = brandName;
        setBrandId(brandCounter);
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
        brandCounter++;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return  String.format("B.ID: %-3d| B.Name: %-10s| ",brandId,brandName);
    }

    public boolean equals(Object original){
        if (original==null){
            return false;
        } else if (getClass() != original.getClass()){
            return false;
        } else {
            Brand other = (Brand) original;
            return ( brandName.equals(other.brandName) &&
                    brandId == other.getBrandId());
        }
    }
}
