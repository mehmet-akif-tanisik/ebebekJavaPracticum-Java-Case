package com.ecommerce.io;

import com.ecommerce.controller.PatikaStore;
import com.ecommerce.entity.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ProductIO {

    private final PatikaStore store = PatikaStore.getInstance();

    public List<Product> loadMobilePhonesData(){
        Scanner fileIn = null;
        String path = "C:\\Users\\Matnsk\\Desktop\\ebebekJavaPracticum-Java-Case\\src\\resources\\mobileProducts.txt";
        List<Product> products = new ArrayList<>();
        try{
            fileIn = new Scanner(new FileInputStream(path));
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }

        while (fileIn.hasNext()){
            StringTokenizer tokens = new StringTokenizer(fileIn.nextLine(),", ");
            List<String> allFields = new ArrayList<>();
            while (tokens.hasMoreTokens()){
                allFields.add(tokens.nextToken());
            }
            MobilePhone phone = new MobilePhone();
            phone.setUnitPrice(Double.parseDouble(allFields.get(0)));
            phone.setDiscountRate(Double.parseDouble(allFields.get(1)));
            phone.setAmountOfStock(Integer.parseInt(allFields.get(2)));
            phone.setProductName(allFields.get(3));
            Brand br = store.getBrand(Integer.parseInt(allFields.get(4)));
            Category ct = store.getCategory(Integer.parseInt(allFields.get(5)));
            phone.setBrand(br);
            phone.setCategory(ct);
            phone.setMemorySize(Integer.parseInt(allFields.get(6)));
            phone.setScreenSize(Double.parseDouble(allFields.get(7)));
            phone.setBatteryCapacity(Integer.parseInt(allFields.get(8)));
            phone.setRamMemorySize(Integer.parseInt(allFields.get(9)));
            phone.setColor(allFields.get(10));
            products.add(phone);
            allFields.clear();
        }
        fileIn.close();

        return products;
    }


    public List<Product> loadLaptopsData(){
        Scanner fileIn = null;
        String path = "C:\\Users\\Matnsk\\Desktop\\ebebekJavaPracticum-Java-Case\\src\\resources\\laptopProducts.txt";
        List<Product> products = new ArrayList<>();
        try{
            fileIn = new Scanner(new FileInputStream(path));
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }

        while (fileIn.hasNext()){
            StringTokenizer tokens = new StringTokenizer(fileIn.nextLine(),", ");
            List<String> allFields = new ArrayList<>();
            while (tokens.hasMoreTokens()){
                allFields.add(tokens.nextToken());
            }
            Laptop laptop = new Laptop();
            laptop.setUnitPrice(Double.parseDouble(allFields.get(0)));
            laptop.setDiscountRate(Double.parseDouble(allFields.get(1)));
            laptop.setAmountOfStock(Integer.parseInt(allFields.get(2)));
            laptop.setProductName(allFields.get(3));
            Brand br = store.getBrand(Integer.parseInt(allFields.get(4)));
            Category ct = store.getCategory(Integer.parseInt(allFields.get(5)));
            laptop.setBrand(br);
            laptop.setCategory(ct);
            laptop.setMemorySize(Integer.parseInt(allFields.get(6)));
            laptop.setRamMemorySize(Integer.parseInt(allFields.get(7)));
            laptop.setScreenSize(Double.parseDouble(allFields.get(8)));
            products.add(laptop);
            allFields.clear();
        }
        fileIn.close();

        return products;
    }


    public List<Brand> loadBrandsData(){
        BufferedReader reader;
        String path = "C:\\Users\\Matnsk\\Desktop\\ebebekJavaPracticum-Java-Case\\src\\resources\\brands.txt";
        List<Brand> brandList = new ArrayList<>();
        try{
            reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            while (line!=null){
                Brand brand = new Brand(line);
                brandList.add(brand);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        return brandList;
    }

    public List<Category> loadCategoriesData(){
        String path = "C:\\Users\\Matnsk\\Desktop\\ebebekJavaPracticum-Java-Case\\src\\resources\\categories.txt";
        List<Category> categoryList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(path));
            while (scanner.hasNextLine()) {
                Category category = new Category(scanner.nextLine());
                categoryList.add(category);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return categoryList;
    }






}
