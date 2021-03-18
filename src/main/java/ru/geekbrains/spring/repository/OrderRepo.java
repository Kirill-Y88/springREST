package ru.geekbrains.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring.model.Order;
import ru.geekbrains.spring.model.Product;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
}
