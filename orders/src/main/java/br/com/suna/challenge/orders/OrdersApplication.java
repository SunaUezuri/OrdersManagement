package br.com.suna.challenge.orders;

import br.com.suna.challenge.orders.main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrdersApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OrdersApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main();
		main.showMenu();
	}
}
