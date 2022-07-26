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

    // todo: so it means that cart is shared across all users? Can we do individual carts for every user?
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
                // todo: does it work? I believe this can produce ConcurrentModificationException as you are trying to remove the item while iterating though the list
                // there is a very nice method removeIf on collections which we can utilize
                // What are other alternatives you see to achieve it? :)
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
                // todo: same modification during iteration may lead to problems
                cart.remove(it);
                cart.add(item);
            }
            else{
                throw new IllegalStateException("there is no product with that id");
            }
        }
    }
}
