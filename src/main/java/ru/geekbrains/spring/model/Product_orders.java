package ru.geekbrains.spring.model;


import javax.persistence.*;

@Entity
@Table(name = "product_orders")
public class Product_orders {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long product_id;

    @Column(name = "order_id")
    private Long order_id;

    public Product_orders(Long idProduct, Long idOrder){
        this.product_id = idProduct;
        this.order_id = idOrder;
    }
/*
    public Product_orders(Long product_id, Long order_id) {
        this.product_id = product_id;
        this.order_id = order_id;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }
}
