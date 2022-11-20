package com.ecommerce.controller;

import com.ecommerce.entity.Brand;
import com.ecommerce.entity.Category;
import com.ecommerce.entity.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PatikaStore {

    private static PatikaStore singleInstance = null;
    private final ArrayList<Product> products;
    private final ArrayList<Brand> brands;
    private final ArrayList<Category> categories;

    private PatikaStore(){
        this.products = new ArrayList<>();
        this.brands = new ArrayList<>();
        this.categories = new ArrayList<>();
    }

    public static PatikaStore getInstance(){
        if (singleInstance==null){
            singleInstance = new PatikaStore();
        }
        return singleInstance;
    }

    //Get brand instance with brand id
    public Brand getBrand(int brandId){
        return brands.get(brandId);
    }

    //Get category instance with category id
    public Category getCategory(int categoryId){
        return categories.get(categoryId);
    }

    //Add category to categories.txt
    public void addCategory(Category category){
        categories.add(category);
    }

    //Add brand to brands.txt
    public void addBrand(Brand brand){
        brands.add(brand);
    }

    // Add Product to the store
    public void addProduct(Product product){
        products.add(product);
    }

    //Delete Product with product id if its valid
    public void deleteProduct(int productId){
        if (isProductValid(productId)){
            products.remove(getProduct(productId));
        }
    }

    //Get Product from store by id if its in the store
    public Product getProduct(int productId){
        for (Product element: products){
            if (element.getProductId() == productId){
                return element;
            }
        }
        return null;
    }

    //Get all products list
    public List<Product> getAllProducts(){
        return products;
    }

    //Get products by category id
    public List<Product> getProductsInCategory(int categoryId){
        List<Product> productsInCategory = new ArrayList<>();
        for (Product element: products){
            if (element.getCategory().getCategoryId() == categoryId){
                productsInCategory.add(element);
            }
        }
        return productsInCategory;
    }

    //Get products filtered by Brand name
    public List<Product> getFilteredProductsByBrand(){
        return products.stream().sorted(Comparator.comparing(Product::getBrandName)).toList();
    }

    //Get products filtered by Product id
    public List<Product> getFilteredProductsById(){
        return products.stream().sorted(Comparator.comparing(Product::getProductId)).toList();
    }

    //Get brands.txt filtered by Name
    public List<Brand> getFilteredBrands(){
        return brands.stream().sorted(Comparator.comparing(Brand::getBrandName)).toList();
    }

    //Get categories.txt filtered by category id
    public List<Category> getCategories(){
        return categories.stream().sorted(Comparator.comparing(Category::getCategoryId)).toList();
    }

    // Check if the category is valid with category id
    public boolean isCategoryValid(int categoryId){
        return (categoryId>=0 && categoryId<categories.size());
    }

    //Check if the brand is valid with brand id
    public boolean isBrandValid(int brandId){
        return (brandId>=0 && brandId<brands.size());
    }

    //Check if the product is valid with product id
    public boolean isProductValid(int productId){
        for (Product element: products){
            if (element.getProductId() == productId){
                return true;
            }
        }
        return false;
    }
}
