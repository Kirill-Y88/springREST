package ru.geekbrains.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.spring.model.Product_orders;

import java.util.Optional;


public interface Product_ordersRepo extends JpaRepository<Product_orders, Long> {

    //Product_orders findByProduct_idAndOrder_id(Long product_id, Long order_id);
    //этот метод не зашел
}
