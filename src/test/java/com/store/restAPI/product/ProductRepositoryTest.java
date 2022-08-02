package com.store.restAPI.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository underTest;

    @Test
    void itShouldFindProductById() {
        //given
        Product expected = new Product(
                "Cafe Macchiato", 10, 8.99
        );
        underTest.save(expected);

        //when
        Optional<Product> outcome = underTest.findProductById(expected.getId());

        //then
        assertEquals(expected, outcome.get());
    }

    @Test
    void itShouldCheckIfProductExistsById() {
        //given
        Product expected = new Product(
                "Cafe Macchiato", 10, 8.99
        );
        underTest.save(expected);

        //when
        Optional<Product> outcome = underTest.findProductById(expected.getId());

        //then
        assertTrue(outcome.isPresent());
    }
}