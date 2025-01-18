package br.com.suna.challenge.orders;

import br.com.suna.challenge.orders.main.Main;
import br.com.suna.challenge.orders.repository.CategoryRepository;
import br.com.suna.challenge.orders.repository.OrderRepository;
import br.com.suna.challenge.orders.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrdersApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OrdersApplication.class, args);
	}

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main(productRepository,
				categoryRepository, orderRepository);
		main.showMenu();
	}
}
