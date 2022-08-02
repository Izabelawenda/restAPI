package com.store.restAPI.product;

import com.store.restAPI.shoppingcart.CartItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    private ProductService underTest;
    @Mock
    private ProductRepository productRepository;
    @Mock
    private ArrayList<CartItem> cart;

    @BeforeEach
    void setUp(){
        underTest = new ProductService(productRepository, cart);
    }

    @Test
    void itShouldFindAllProducts() {

        //when
        underTest.findAll();

        //then
        verify(productRepository).findAll();

    }

    @Test
    @Disabled
    void itShouldShowCart() {

        //when
        underTest.showCart();

        //then
        verify(productRepository).findAll();
    }

    @Test
    void itShouldAddProductToCart() {
        //given
        CartItem expected = new CartItem(
                1L, 10
        );

        //when
        underTest.addProductToCart(expected);

        //then
        ArgumentCaptor<CartItem> cartItemArgumentCaptor = ArgumentCaptor.forClass(CartItem.class);

        verify(cart).add(cartItemArgumentCaptor.capture());

        CartItem capturedCartItem = cartItemArgumentCaptor.getValue();

        assertThat(capturedCartItem).isEqualTo(expected);
    }

    @Test
    @Disabled
    void itShouldRemoveCartItem() {
        //given


        //when


        //then
    }

    @Test
    @Disabled
    void itShouldModifyCartItem() {
        //given


        //when


        //then
    }
}