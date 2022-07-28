package com.store.restAPI.shoppingcart;

import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;

@SessionScope
public class ShoppingCart {

    private ArrayList<CartItem> cartItems;
    private double totalPrice;

    public ShoppingCart() {
    }

    public ArrayList<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(ArrayList<CartItem> cartItems) {
        this.cartItems = cartItems;
        double totalPrice = 0;
        for(CartItem item : cartItems){
            totalPrice+=item.getPrice();
        }
        setTotalPrice(totalPrice);
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
