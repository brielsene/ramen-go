package br.com.ramen_go.repositories;

import br.com.ramen_go.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
