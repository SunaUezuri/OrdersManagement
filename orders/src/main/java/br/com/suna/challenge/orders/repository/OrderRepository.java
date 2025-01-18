package br.com.suna.challenge.orders.repository;

import br.com.suna.challenge.orders.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
