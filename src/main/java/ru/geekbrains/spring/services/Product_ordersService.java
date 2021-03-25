package ru.geekbrains.spring.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.model.Product_orders;
import ru.geekbrains.spring.repository.Product_ordersRepo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class Product_ordersService {
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    Product_ordersRepo product_ordersRepo;

    public void put(Long idProduct, Long idOrder){
        product_ordersRepo.saveAndFlush(new Product_orders(idProduct,idOrder));
    }

    public void delete(Long idProduct, Long idOrder){
        //product_ordersRepo.delete(product_ordersRepo.findByProduct_idAndOrder_id(idProduct,idOrder));
        product_ordersRepo.delete((Product_orders)(entityManager.createQuery(String.format(" SELECT po FROM product_orders po WHERE po.product_id='%d' and po.order_id='%d' ", idProduct, idOrder))).getResultList().get(0));
        //этот метод тоже не зашел : IllegalArgumentException: org.hibernate.hql.internal.ast.QuerySyntaxException: product_orders is not mapped [ SELECT po FROM product_orders po WHERE po.product_id='13' and po.order_id='1' ]] with root cause
    }


}
