package br.com.suna.challenge.orders.main;

import br.com.suna.challenge.orders.model.Category;
import br.com.suna.challenge.orders.model.Order;
import br.com.suna.challenge.orders.model.Product;
import br.com.suna.challenge.orders.repository.CategoryRepository;
import br.com.suna.challenge.orders.repository.OrderRepository;
import br.com.suna.challenge.orders.repository.ProductRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private Scanner scanner = new Scanner(System.in);

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private OrderRepository orderRepository;

    //Main class constructor for support of the data
    public Main(ProductRepository productRepository,
                CategoryRepository categoryRepository,
                OrderRepository orderRepository) {

        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.orderRepository = orderRepository;
    }


    public void showMenu() {
        /*
        * This method uses texts to give the users
        * the information needed and utilizes a while loop
        * to make sure that the user type a valid option
        * of the switch-case without reseting the program
        */

        var option = -1;
        System.out.println("""
                Welcome to our orders management system!
                
                Please choose a option to continue.
                
                """);

        while (option != 0){

            var menu = """
                    1- Register a product
                    2- Register a category
                    3- Register a order
                    4- List products
                    5- List categories
                    6- List orders
                    
                    0- exit
                    """;

            System.out.println(menu);
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option){

                case 1:
                    registerProduct();
                    break;

                case 2:
                    registerCategory();
                    break;

                case 3:
                    registerOrder();
                    break;

                case 4:
                    listProducts();
                    break;

                case 5:
                    listCategories();
                    break;

                case 6:
                    listOrders();
                    break;

                case 0:
                    System.out.println("Thanks for your contribution!");
                    break;

                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private void registerProduct() {
        /*
        * This method utilizes JPA to make operation
        * Create from the CRUD for the class Product.
        *
        * productName: variable to save the name of the
        * product inserted
        *
        * productPrice: variable to save the price in the Double
        * format of the product
        */

        System.out.println("""
                Please insert the requested items.
                
                Product name:
                """);

        var productName = scanner.nextLine();

        System.out.println("\nProduct price: ");
        Double productPrice = scanner.nextDouble();

        Product product = new Product(productName, productPrice);
        productRepository.save(product);
        System.out.println("Product " + product.getName() + " has been succesfully registered!");
    }

    private void registerCategory() {
        /*
         * This method utilizes JPA to make operation
         * Create from the CRUD for the class Category
         *
         * categoryName: Variable to save the name of the
         * category inserted
         */

        System.out.println("""
                Please insert the requested items:
                
                Category name:
                """);

        var categoryName = scanner.nextLine();

        Category category = new Category(categoryName);
        categoryRepository.save(category);
        System.out.println("Category " + categoryName + " has been sucessfully registered!");
    }

    private void registerOrder() {
        /*
         * This method utilizes JPA to make operation
         * Create from the CRUD for the class Order.
         *
         * It uses a try and catch to make sure that
         * the user insert the date in the right format,
         * and if not give a message explaining the error.
         *
         * inputDate: variable to save the date inserted
         * by the user
         *
         * orderDate = object that converts the String of inputDate
         * into a LocalDate object
         */

        System.out.println("""
                Please insert the requested items:
                
                Order date (format: yyyy-MM-dd):
                """);

        var inputDate = scanner.nextLine();

        try {
                LocalDate orderDate = LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                Order order = new Order(orderDate);

                orderRepository.save(order);
                System.out.println("Order succesfully registered!");

        } catch (DateTimeParseException e){
            System.out.println("Invalid date format. Please use the format yyyy-MM-dd");
        }
    }

    private void listProducts() {
        /*
        * Method that uses a List to save all the products
        * encoutered in the database and after that it
        * shows all the encoutered items in it
        */

        List<Product> products = productRepository.findAll();

        products.forEach(System.out::println);
    }

    private void listCategories() {
        /*
         * Method that uses a List to save all the categories
         * encoutered in the database and after that it
         * shows all the encoutered items in it
         */

        List<Category> categories = categoryRepository.findAll();

        categories.forEach(System.out::println);
    }

    private void listOrders() {
        /*
         * Method that uses a List to save all the orders
         * encoutered in the database and after that it
         * shows all the encoutered items in it
         */

        List<Order> orders = orderRepository.findAll();

        orders.forEach(System.out::println);
    }
}
