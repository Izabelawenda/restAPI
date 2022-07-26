package com.store.restAPI.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository repository) {
        // todo: this is ok for testing, But I think it should not be included in configuration other than testing
        // If product list is modified by someone else (other application), as soon as you restart this application, you will add/modify the product list, which may be not desirable.
        // Is it possible to run this configuration on property configuration condition on "test" profile used condition?
        return args -> {
            Product light_roast_coffee = new Product(
                    "Light roast coffee",
                    10,
                    12.59
            );

            Product medium_roast_coffee = new Product(
                    "Medium roast coffee",
                    10,
                    13.59
            );

            Product dark_roast_coffee = new Product(
                    "Dark roast coffee",
                    10,
                    14.59
            );

            repository.saveAll(
                    List.of(light_roast_coffee,medium_roast_coffee,dark_roast_coffee)
            );
        };
    }
}
