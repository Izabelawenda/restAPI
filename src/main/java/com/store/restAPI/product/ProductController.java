package com.store.restAPI.product;

import com.store.restAPI.shoppingcart.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("products")
    public List<Product> getProducts() {
        return productService.findAll();
    }

    @PostMapping("products")
    public void addNewProduct(@RequestBody CartItem item) {
        productService.addProductToCart(item);
    }

    @GetMapping("cart")
    public List<CartItem> getCart() {
        return productService.showCart();
    }

    @PostMapping("cart")
    public void removeCartItem(@RequestBody CartItem item) {
        productService.removeCartItem(item);
    }

    @PostMapping("cartmodify")
    public void modifyCartItem(@RequestBody CartItem item) {
        productService.modifyCartItem(item);
    }

}
