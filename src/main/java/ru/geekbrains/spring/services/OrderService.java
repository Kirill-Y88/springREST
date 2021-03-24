package ru.geekbrains.spring.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.model.Order;
import ru.geekbrains.spring.model.OrderDto;
import ru.geekbrains.spring.model.Product;
import ru.geekbrains.spring.model.ProductDto;
import ru.geekbrains.spring.repository.OrderRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

   /* public List<Order> findAll(){
       return orderRepo.findAll();
    }*/


    public List<OrderDto> findAll(){
        List<OrderDto> orderDtos = null;
       orderDtos =  (orderRepo.findAll().stream().map(OrderDto::new)).collect(Collectors.toList());
        return orderDtos;
    }

    public void delete(){

    }

    public List<ProductDto> getProductOrder(Long id){
        Order order;
        order =  orderRepo.getOne(id);
        return order.getProducts().stream().map(ProductDto::new).collect(Collectors.toList());
    }

}
