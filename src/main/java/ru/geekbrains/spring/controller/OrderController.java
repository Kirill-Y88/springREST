package ru.geekbrains.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.spring.model.Order;
import ru.geekbrains.spring.model.Product;
import ru.geekbrains.spring.services.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    ProductController productController;


    @GetMapping
    public List<Order> getAll(){
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public List<Product> getAllorder(Long id){
        return productController.getAllorder(id);
    }




}
