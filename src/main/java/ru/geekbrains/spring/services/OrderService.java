package ru.geekbrains.spring.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.model.Order;
import ru.geekbrains.spring.repository.OrderRepo;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    public List<Order> findAll(){
       return orderRepo.findAll();
    }

    public void delete(){

    }

}
