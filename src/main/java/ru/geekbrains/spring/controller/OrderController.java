package ru.geekbrains.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.model.Order;
import ru.geekbrains.spring.model.OrderDto;
import ru.geekbrains.spring.model.Product;
import ru.geekbrains.spring.model.ProductDto;
import ru.geekbrains.spring.services.OrderService;
import ru.geekbrains.spring.services.Product_ordersService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    ProductController productController;

    @Autowired
    private Product_ordersService product_ordersService;



    @GetMapping
    public List<OrderDto> getAll(){
        return orderService.findAll();
    }

    @GetMapping("/user/{id}")
    public List<ProductDto> getProductOrder(@PathVariable Long id){
      return   orderService.getProductOrder(id);
    }

    @GetMapping("/user/{idOrder}/{idProduct}")
    public List<ProductDto> putProduct (@PathVariable Long idProduct, @PathVariable Long idOrder){
        product_ordersService.put(idProduct,idOrder);
        return orderService.getProductOrder(idOrder);
    }

    @GetMapping("/user/{idOrder}/{idProduct}/delete")
    public List<ProductDto> deleteProduct (@PathVariable Long idProduct, @PathVariable Long idOrder){
        product_ordersService.delete(idProduct,idOrder);
        return orderService.getProductOrder(idOrder);
    }



}
