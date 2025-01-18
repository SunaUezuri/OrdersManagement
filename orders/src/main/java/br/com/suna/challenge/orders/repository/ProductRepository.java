package br.com.suna.challenge.orders.repository;

import br.com.suna.challenge.orders.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
