package com.store.restAPI.product;

import javax.persistence.*;

@Entity
@Table
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long id;
    private String title;
    private Integer quantity;
    private double price;

    public Product() {
    }

    public Product(Long id, String title, Integer quantity, double price) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    public Product(String title, Integer quantity, double price) {
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", quantity='" + quantity + '\'' +
                ", price=" + price +
                '}';
    }
}
