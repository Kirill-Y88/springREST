package ru.geekbrains.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.model.Product;
import ru.geekbrains.spring.model.ProductDto;
import ru.geekbrains.spring.model.SortDir;
import ru.geekbrains.spring.services.ProductService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public Page<ProductDto> getAll(@RequestParam(defaultValue = "0") Integer page,
                                @RequestParam(defaultValue = "35") Integer size,
                                @RequestParam(required = false)SortDir sortName,
                                @RequestParam(required = false)SortDir sortCost
                                )  {
        Page<ProductDto> products;
        if(page < 0 || size < 0 ){
          //  return error(" Введены неверные значения ");

        }
        if( (products = productService.getAll(page,size,sortName,sortCost)).toList().size() == 0){
          //  return error(" Товары закончились ");
            return products;
        }
        else {
            return products;
        }
    }

    /*@GetMapping("/err")
    public Page<Product> error(String msg){
        List <Product> errList = new ArrayList<>();
        Product err = new Product();
        err.setName(msg);
        err.setCost(555);
        errList.add(err);
        return errList;
    }*/

    @GetMapping("/{id}")
    public List<Product> getAllorder (Long id){
        return productService.getOrder(id);
    }

   /* @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id){
        return (productService.getId(id)).convertToDto();
    }
*/

    @PostMapping
    public ProductDto addProduct(@RequestBody ProductDto productDto){
        Product product = productDto.convertToProduct();
        return (productService.saveOrUpdate(product)).convertToDto();
    }

    @PutMapping
    public ProductDto updateProduct(@RequestParam ProductDto productDto){
        Product product = productDto.convertToProduct();
        return (productService.saveOrUpdate(product)).convertToDto();
    }


    @DeleteMapping("/{id}")
    public int deleteProduct(@PathVariable Long id){
        productService.delete(id);
        return HttpStatus.OK.value();
    }

    @GetMapping("/findLess")
    public List<Product> findLessThan(@RequestParam int max){
        return productService.findLessThan(max);
    }

    @GetMapping("/findGreater")
    public List<Product> findGreaterThan(@RequestParam int min){
        return productService.findGreaterThan(min);
    }

    @GetMapping("/findBetween")
    public List<Product> findBetween(@RequestParam int min, @RequestParam int max){
        return productService.findBetween(min, max);
    }

    @GetMapping("/findName")
    public List<Product> findName(@RequestParam String name){
        return productService.findNameStart(name);
    }

}
