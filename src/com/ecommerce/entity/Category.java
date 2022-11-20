package com.ecommerce.entity;

public class Category {

    private static int categoryCounter = 0;
    private int categoryId;
    private String categoryName;

    public Category(String categoryName) {
        this.categoryName = categoryName;
        setCategoryId(categoryCounter);
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
        categoryCounter++;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return String.format("C.ID: %-3d| C.Name: %-14s| ",categoryId,categoryName);
    }

    public boolean equals(Object original){
        if (original==null){
            return false;
        } else if (getClass() != original.getClass()){
            return false;
        } else {
            Category other = (Category) original;
            return (categoryName.equals(other.getCategoryName()) &&
                    categoryId == other.getCategoryId());
        }
    }
}
