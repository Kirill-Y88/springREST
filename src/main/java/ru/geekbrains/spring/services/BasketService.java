package ru.geekbrains.spring.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.model.Product;
import ru.geekbrains.spring.model.ProductIntoBasket;
import ru.geekbrains.spring.repository.BasketRepo;
import ru.geekbrains.spring.repository.ProductRepo;

import java.util.List;

@Service
public class BasketService {

   @Autowired
   BasketRepo basketRepo;

   @Autowired
    ProductService productService;

    public List<ProductIntoBasket> getAll (){
        List<ProductIntoBasket> product = null;
        product = basketRepo.findAll(Sort.by("name").ascending());
        return product;
    }

    public ProductIntoBasket getId(Long id){
        return basketRepo.findById(id).get();
    }

    public void delete(Long id){
        productService.saveOrUpdate(getId(id).convertToProduct());
        basketRepo.deleteById(id);
    }

    public ProductIntoBasket saveOrUpdate(Product product){
        return basketRepo.save(product.convertToProductIntoBasket());
    }


}
