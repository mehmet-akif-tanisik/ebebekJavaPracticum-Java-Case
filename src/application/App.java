package application;
import com.ecommerce.view.ProductConsole;

public class App {


    public static void main(String[] args) {
        ProductConsole application = new ProductConsole();
        application.run();

    }
}


































/*
PatikaStore store = new PatikaStore();

        Brand samsung = new Brand(0,"samsung");
        Brand lenovo = new Brand(1,"lenovo");
        Brand apple = new Brand(2,"apple");
        Brand casper = new Brand(3, "casper");

        Category mobile = new Category(0,"mobile");
        Category laptop = new Category(1,"laptop");


        Product p1 = new MobilePhone();
        Product p2 = new MobilePhone();
        Product p3 = new MobilePhone();
        p1.setBrand(samsung);
        p1.setCategory(mobile);
        p2.setBrand(apple);
        p2.setCategory(mobile);
        p3.setBrand(casper);
        p3.setCategory(mobile);


        Product p4 = new Laptop();
        Product p5 = new Laptop();
        Product p6 = new Laptop();
        p4.setBrand(samsung);
        p4.setCategory(laptop);
        p5.setBrand(apple);
        p5.setCategory(laptop);
        p6.setBrand(casper);
        p6.setCategory(laptop);

        store.addProduct(p1);
        store.addProduct(p2);
        store.addProduct(p3);
        store.addProduct(p4);
        store.addProduct(p5);
        store.addProduct(p6);

        store.printProducts();

        System.out.println("-------------------");

        store.deleteProduct(4);
        store.deleteProduct(4);

        store.printProducts();

        System.out.println("-------------------");

        store.printFilteredProductsByBrand();
        System.out.println("------------------------");
        store.printFilteredProductsById();

        System.out.println("------------------------");

        store.printProductsInCategory(1);
        System.out.println("------------------------");

        store.printProductsInCategory(0);
 */