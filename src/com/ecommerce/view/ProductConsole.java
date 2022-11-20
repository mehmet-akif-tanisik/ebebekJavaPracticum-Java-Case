package com.ecommerce.view;
import com.ecommerce.controller.PatikaStore;
import com.ecommerce.entity.*;
import com.ecommerce.io.ProductIO;
import java.util.List;
import java.util.Scanner;

public class ProductConsole {

    private final PatikaStore store;
    private static final Scanner keyboard = new Scanner(System.in);
    private ProductIO productIO;

    public ProductConsole() {
        this.store = PatikaStore.getInstance();
        this.productIO = new ProductIO();
        addInitialCategories();
        addInitialBrands();
        addInitialMobilePhones();
        addInitialLaptops();
    }

    private void addInitialCategories() {
        List<Category> categoryList = productIO.loadCategoriesData();

        for (Category element: categoryList){
            store.addCategory(element);
        }
    }

    private void addInitialBrands() {
       List<Brand> brandList = productIO.loadBrandsData();

       for (Brand element: brandList){
           store.addBrand(element);
       }
    }

    private void addInitialMobilePhones(){
        List<Product> productList = productIO.loadMobilePhonesData();

        for (Product element: productList){
            store.addProduct(element);
        }
    }

    private void addInitialLaptops(){
        List<Product> productList = productIO.loadLaptopsData();

        for (Product element: productList){
            store.addProduct(element);
        }
    }

    private int menu() {
        System.out.println("""
                
                |-------------------------------------------------------|
                |---------------------PATIKA STORE----------------------|
                |-------------------------------------------------------|
                | 1. Add product to the PatikaStore                     |
                | 2. Show product specifications by product id
                | 3. List all products in the PatikaStore               |
                | 4. List all products by category Id                   |
                | 5. List all brands by brand name in ascending order   |
                | 6. List all products by product id in ascending order |
                | 7. Remove product from PatikaStore by product id      |
                | 0. Exit the PatikaStore                               |
                | ------------------------------------------------------|
                
                """
        );
        return readInput();
    }

    private int readInput() {
        int choice;
        while (true) {
            System.out.print("Please enter operation number: ");
            choice = keyboard.nextInt();
           if (choice>=0 && choice<=7){
               break;
           } else {
               System.out.println("Invalid operation number! Try again.");
           }
        }
        return choice;
    }

    public void run() {
        while (true) {
            int choice = menu();
            switch (choice) {
                case 0 -> System.exit(0);
                case 1 -> addProduct();
                case 2 -> showProduct();
                case 3 -> showAll();
                case 4 -> listByCategory();
                case 5 -> filteredBrands();
                case 6 -> filterById();
                case 7 -> removeProduct();
                default -> throw new AssertionError();
            }
        }
    }

    private void addProduct() {
        printCategories();
        int categoryId = readCategory();
        int brandId = readBrand();

        if (store.getCategory(categoryId).getCategoryName().equals("Laptop")){
            Laptop l = createLaptop(categoryId,brandId);
            store.addProduct(l);
        } else {
            MobilePhone mp = createMobile(categoryId,brandId);
            store.addProduct(mp);
        }
    }

    private void listByCategory(){
        printCategories();
        int categoryId = readCategory();
        if (store.getCategory(categoryId).getCategoryName().equals("Laptop")){
            strFormatForLaptops();
        } else {
            strFormatForMobilePhones();
        }

        List<Product> productList = store.getProductsInCategory(categoryId);
        printProducts(productList);
    }

    private void showAll(){
        printProducts(store.getAllProducts());
    }

    private void showProduct(){
        int productId = readProduct();

        System.out.println(store.getProduct(productId));
    }

    private void filteredBrands(){
        List<Brand> filteredBrands = store.getFilteredBrands();
        printBrands(filteredBrands);
    }

    private void filterById(){
        List<Product> filteredById = store.getFilteredProductsById();
        printProducts(filteredById);
    }

    private void removeProduct(){
        int productId = readProduct();

        store.deleteProduct(productId);
        System.out.println("ID " + productId + " has been deleted successfully from Store.");
    }


    private MobilePhone createMobile(int categoryId, int brandId){
        System.out.print("Unit Price: ");
        double price = keyboard.nextDouble();
        System.out.print("Discount rate: ");
        double discountRate = keyboard.nextDouble();
        System.out.print("Stock amount:");
        int stockAmount = keyboard.nextInt();
        keyboard.nextLine();
        System.out.print("Product name: ");
        String productName = keyboard.nextLine();
        System.out.print("Memory size: ");
        int memorySize = keyboard.nextInt();
        System.out.print("Screen size: ");
        double screenSize = keyboard.nextDouble();
        System.out.print("Battery capacity: ");
        int batteryCapacity = keyboard.nextInt();
        System.out.print("Ram memory size: ");
        int ramMemorySize = keyboard.nextInt();
        keyboard.nextLine();
        System.out.print("Color: ");
        String color = keyboard.nextLine();

        return new MobilePhone(price,discountRate,stockAmount,productName,store.getBrand(brandId),store.getCategory(categoryId),memorySize,screenSize,batteryCapacity,ramMemorySize,color);
    }

    private Laptop createLaptop(int categoryId, int brandId){
        System.out.print("Unit Price: ");
        double price = keyboard.nextDouble();
        System.out.print("Discount rate: ");
        double discountRate = keyboard.nextDouble();
        System.out.print("Stock amount:");
        int stockAmount = keyboard.nextInt();
        keyboard.nextLine();
        System.out.print("Product name: ");
        String productName = keyboard.nextLine();
        System.out.print("Memory size: ");
        int memorySize = keyboard.nextInt();
        System.out.print("Screen size: ");
        double screenSize = keyboard.nextDouble();
        System.out.print("Ram memory size: ");
        int ramMemorySize = keyboard.nextInt();

        return new Laptop(price,discountRate,stockAmount,productName,store.getBrand(brandId),store.getCategory(categoryId),memorySize,ramMemorySize,screenSize);
    }

    private int readCategory(){
        int categoryId;
        while (true) {
            System.out.print("Please enter category ID: ");
            categoryId = keyboard.nextInt();
            if (store.isCategoryValid(categoryId)) {
                break;
            } else {
                System.out.println("Invalid category ID! Please enter valid ID.");
            }
        }
        return categoryId;
    }

    private int readProduct(){
        int productId;
        while (true){
            System.out.print("Please enter product ID: ");
            productId = keyboard.nextInt();
            if (store.isProductValid(productId)){
                break;
            } else {
                System.out.println("Invalid product ID! Please enter valid ID.");
            }
        }
        return productId;
    }

    private int readBrand(){
        int brandId;
        while (true){
            System.out.print("Please enter brand ID: ");
            brandId = keyboard.nextInt();
            if (store.isBrandValid(brandId)){
                break;
            } else {
                System.out.println("Invalid brand ID! Please enter valid ID.");
            }
        }
        return brandId;
    }



    private void printCategories() {
        System.out.println("|----------------------------------|");
        System.out.println("|       List of categories         |");
        System.out.println("|----------------------------------|");
       for (Category element: store.getCategories()){
           System.out.println("| "+element);
       }
        System.out.println("|----------------------------------|");
    }

    private void printProducts(List<Product> products){
        for (Product element: products){
            System.out.println(element);
        }
    }

    private void printBrands(List<Brand> brands){
        for (Brand element: brands){
            System.out.println(element);
        }
    }

    private void strFormatForMobilePhones(){
        System.out.println("-------------------------------------------------------------------------------------------------------------------------" +
                "----------------------------------------------------------------------------------------------------");
        System.out.printf("%-9s| %-22s| %-10s| %-18s| %-10s| %-22s| %-15s| %-15s| %-11s| %-14s| %-12s| %-14s| %-7s| %-15s|"
                ,"C.ID ","C.Name "," B.ID ","B.Name "," P.ID ","P.Name ","Price ","Discount ","Stock "," Memory ","SSize ","Battery ","RAM ","Color ");
        System.out.println("\n-------------------------------------------------------------------------------------------------------------------------" +
                "----------------------------------------------------------------------------------------------------");
    }

    private void strFormatForLaptops(){
        System.out.println("\n-----------------------------------------------------------------------------------------------------------------------" +
                "---------------------------------------------------------------------");
        System.out.printf("%-9s| %-22s| %-10s| %-18s| %-10s| %-22s| %-15s| %-15s| %-11s| %-14s| %-12s| %-7s|"
                ,"C.ID ","C.Name "," B.ID ","B.Name ","P.ID ","P.Name ","Price ","Discount ","Stock ","Memory ","SSize ","RAM ");
        System.out.println("\n-----------------------------------------------------------------------------------------------------------------------" +
                "---------------------------------------------------------------------");
    }




}
