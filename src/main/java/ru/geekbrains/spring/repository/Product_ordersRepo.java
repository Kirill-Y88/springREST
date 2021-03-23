package ru.geekbrains.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.spring.model.Product_orders;


public interface Product_ordersRepo extends JpaRepository<Product_orders, Long> {
}
