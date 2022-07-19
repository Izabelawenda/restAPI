package com.store.restAPI.product;


import com.store.restAPI.shoppingcart.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ArrayList<CartItem> cart;

    @Autowired
    public ProductService(ProductRepository productRepository, ArrayList<CartItem> cart) {
        this.productRepository = productRepository;
        this.cart = cart;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<CartItem> showCart() {return cart;}


    public void addProductToCart(CartItem item) {

        Optional<Product> productOptional = productRepository.findProductById(item.getId());
        if(productOptional.isEmpty()){
            throw new IllegalStateException("there is no product with that id");
        }
        else if(item.getQuantity() >  productOptional.get().getQuantity()){
            throw new IllegalStateException("the quantity of this product is lower than requested");
        }
        cart.add(item);
    }

    public void removeCartItem(CartItem item) {

        for(CartItem it: cart){
            if(it.getId().equals(item.getId())){
                cart.remove(it);
            }
            else{
                throw new IllegalStateException("there is no product with that id");
            }
        }
    }

    public void modifyCartItem(CartItem item) {

        for(CartItem it: cart){
            if(it.getId().equals(item.getId())){
                cart.remove(it);
                cart.add(item);
            }
            else{
                throw new IllegalStateException("there is no product with that id");
            }
        }
    }
}
