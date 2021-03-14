package ru.geekbrains.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.spring.model.ProductIntoBasket;

public interface BasketRepo extends JpaRepository<ProductIntoBasket, Long> {
}
