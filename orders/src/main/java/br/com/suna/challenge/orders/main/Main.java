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

                case 0:
                    System.out.println("Thanks for your contribution!");
                    break;

                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private void registerProduct() {
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
        List<Product> products = productRepository.findAll();

        products.forEach(System.out::println);
    }

    private void listCategories() {
        List<Category> categories = categoryRepository.findAll();

        categories.forEach(System.out::println);
    }
}
