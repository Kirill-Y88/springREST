package ru.geekbrains.spring.model;


import javax.persistence.*;

@Entity
@Table(name = "productsintobasket")
public class ProductIntoBasket extends Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cost")
    private int cost;

    public ProductIntoBasket() {
    }


    public ProductIntoBasket(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public Product convertToProduct(){
        Product product = new Product();
        product.setName(this.getName());
        product.setCost(this.getCost());
        return product;
    }

}
