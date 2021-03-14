package ru.geekbrains.spring.model;


import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cost")
    private int cost;

    public Product() {
    }

    public Product(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public ProductDto convertToDto(){
        ProductDto productDto = new ProductDto(this);
        return productDto;
    }

    public ProductIntoBasket convertToProductIntoBasket(){
        ProductIntoBasket productIntoBasket = new ProductIntoBasket();
        productIntoBasket.setName(this.getName());
        productIntoBasket.setCost(this.getCost());
        return productIntoBasket;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
