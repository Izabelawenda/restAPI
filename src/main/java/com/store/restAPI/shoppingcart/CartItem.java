package com.store.restAPI.shoppingcart;

public class CartItem {
    private Long id;
    private Integer quantity;


    public CartItem(Long id, Integer quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}
