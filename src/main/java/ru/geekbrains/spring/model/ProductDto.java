package ru.geekbrains.spring.model;



public class ProductDto {
    private Long id;
    private String name;
    private int cost;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.cost = product.getCost();
    }

    public ProductDto(){

    }

    /*public ProductDto(){

    }*/

    public Product convertToProduct(){
        Product product =new Product();
        product.setName(this.getName());
        product.setCost(this.getCost());
        return product;
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
