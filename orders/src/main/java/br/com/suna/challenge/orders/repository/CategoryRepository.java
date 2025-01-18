package br.com.suna.challenge.orders.repository;

import br.com.suna.challenge.orders.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
