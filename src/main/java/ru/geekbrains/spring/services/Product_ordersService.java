package ru.geekbrains.spring.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.model.Product_orders;
import ru.geekbrains.spring.repository.Product_ordersRepo;

@Service
public class Product_ordersService {

    @Autowired
    Product_ordersRepo product_ordersRepo;

    public void put(Long idProduct, Long idOrder){
        product_ordersRepo.save(new Product_orders(idProduct,idOrder));
    }


}
