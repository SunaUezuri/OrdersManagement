package br.com.suna.challenge.orders.main;

import br.com.suna.challenge.orders.model.Product;
import br.com.suna.challenge.orders.repository.CategoryRepository;
import br.com.suna.challenge.orders.repository.OrderRepository;
import br.com.suna.challenge.orders.repository.ProductRepository;

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
                    
                    0- exit
                    """;

            System.out.println(menu);
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option){

                case 1:
                    System.out.println("Product registration");
                    break;

                case 2:
                    System.out.println("Category registration");
                    break;

                case 3:
                    System.out.println("Orders registration");
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
        var productPrice = scanner.nextLine();

        Product product = new Product();

    }
}
