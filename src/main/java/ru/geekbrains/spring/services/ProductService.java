package ru.geekbrains.spring.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.spring.model.Product;
import ru.geekbrains.spring.model.ProductDto;
import ru.geekbrains.spring.model.SortDir;
import ru.geekbrains.spring.repository.ProductRepo;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Transactional
    public Page<ProductDto> getAll(int page, int size, SortDir sortName, SortDir sortCost){

        Page<ProductDto> products = null;
            if(sortName == null && sortCost == null){
                products = productRepo.findAll(PageRequest.of(page,size, Sort.by("cost").ascending())).map(ProductDto::new);
        }
            if(sortName != null && sortCost == null){
                if (sortName == SortDir.ASC){
                    products = productRepo.findAll(PageRequest.of(page,size, Sort.by("name").ascending())).map(ProductDto::new);
                }else {
                    products = productRepo.findAll(PageRequest.of(page,size, Sort.by("name").descending())).map(ProductDto::new);
                }
            }
            if(sortName == null && sortCost != null){
                if (sortCost == SortDir.ASC){
                    products = productRepo.findAll(PageRequest.of(page,size, Sort.by("cost").ascending())).map(ProductDto::new);
                }else {
                    products = productRepo.findAll(PageRequest.of(page,size, Sort.by("cost").descending())).map(ProductDto::new);
                }
            }
            if(sortName != null && sortCost != null){
                if(sortName == SortDir.ASC && sortCost == SortDir.ASC){
                    products = productRepo.findAll(PageRequest.of(page,size, Sort.by("cost").ascending().and(Sort.by("name").ascending()))).map(ProductDto::new);
                }
                if(sortName == SortDir.DESC && sortCost == SortDir.ASC){
                    products = productRepo.findAll(PageRequest.of(page,size, Sort.by("cost").ascending().and(Sort.by("name").descending()))).map(ProductDto::new);
                }
                if(sortName == SortDir.ASC && sortCost == SortDir.DESC){
                    products = productRepo.findAll(PageRequest.of(page,size, Sort.by("cost").descending().and(Sort.by("name").ascending()))).map(ProductDto::new);
                }
                if(sortName == SortDir.DESC && sortCost == SortDir.DESC){
                    products = productRepo.findAll(PageRequest.of(page,size, Sort.by("cost").descending().and(Sort.by("name").descending()))).map(ProductDto::new);
                }
            }
            return products;
    }

    public Product getId(Long id){
        return productRepo.findById(id).get();
    }

   /* public List<Product> getOrder(Long id){
        return productRepo.findProductsByOrder_id(id);
    }*/

    public Product saveOrUpdate(Product product){
        return productRepo.save(product);
    }


    public void delete(Long id){
        productRepo.deleteById(id);
    }

    public List<Product> findLessThan(int max){
        return productRepo.findProductsByCostLessThan(max);
    }

    public List<Product> findGreaterThan(int min){
        return productRepo.findProductsByCostGreaterThan(min);
    }

    public List<Product>findBetween(int min, int max){
        return productRepo.findProductsByCostBetween(min,max);
    }

    public List<Product>findNameStart(String name){
        return productRepo.findProductsByNameStartsWith(name);
    }

}
