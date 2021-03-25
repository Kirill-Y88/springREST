package ru.geekbrains.spring.model;

import javax.persistence.Column;

public class OrderDto {

    private Long id;

    private String username;

    public OrderDto() {
    }

    public OrderDto(Order order){
    this.id = order.getId();
    this.username = order.getUsername();
    }

    public Order convertToOrder(){
        Order order = new Order();
        order.setId(this.id);
        order.setUsername(this.username);
        return order;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
