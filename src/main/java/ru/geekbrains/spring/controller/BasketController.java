package ru.geekbrains.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.model.ProductIntoBasket;
import ru.geekbrains.spring.services.BasketService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/basket")
public class BasketController {

    @Autowired
    BasketService basketService;

    @GetMapping
    public List<ProductIntoBasket> getAll(){
       return basketService.getAll();
    }

    @DeleteMapping("/{id}")
    public int deleteProductFromBasket (@PathVariable Long id){
        basketService.delete(id);
        return HttpStatus.OK.value();
    }


}
