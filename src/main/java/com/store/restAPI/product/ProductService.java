package com.store.restAPI.product;


import com.store.restAPI.shoppingcart.CartItem;
import com.store.restAPI.shoppingcart.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    ArrayList<CartItem> cart;
    ShoppingCart shoppingCart = new ShoppingCart();

    @Autowired
    public ProductService(ProductRepository productRepository, ArrayList<CartItem> cart) {
        this.productRepository = productRepository;
        this.cart = cart;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<CartItem> showCart() {

        System.out.println("Total cart price: " + shoppingCart.getTotalPrice());
        return shoppingCart.getCartItems();
    }

    public void addProductToCart(CartItem item) {

        Optional<Product> productOptional = productRepository.findProductById(item.getId());
        if(productOptional.isEmpty()){
            throw new IllegalStateException("there is no product with that id");
        }
        else if(item.getQuantity() >  productOptional.get().getQuantity()){
            throw new IllegalStateException("the quantity of this product is lower than requested");
        }
        item.setPrice(productOptional.get().getPrice());
        cart.add(item);
        shoppingCart.setCartItems(cart);
    }

    public void removeCartItem(CartItem item) {

        if(cart.removeIf(n -> n.getId().equals(item.getId()))){
            shoppingCart.setCartItems(cart);
            System.out.println("item removed");
        }
        else{
            throw new IllegalStateException("there is no product with that id");
        }
    }

    public void modifyCartItem(CartItem item) {

        if(cart.removeIf(n -> n.getId().equals(item.getId()))){
            cart.add(item);
            shoppingCart.setCartItems(cart);
        }
        else{
            throw new IllegalStateException("there is no product with that id");
        }
    }
}
