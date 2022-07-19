package com.store.restAPI.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunnerUser(UserRepository repository) {
        return args -> {
            User iza = new User(
                    "iza@gmail.com",
                    "$2a$10$U87IFlm9DYXRITUSnfdfDuknz8ijJCcK9UVR4D4kUDu7w13zPuURK"
            );

            User andrzej = new User(
                    "andrzej@gmail.com",
                    "$2a$10$fmYOxyvWBr47wAg1m/ryy.G4J1PbT2LRj6m7oENkBtEsGocansE9G"
            );

            User tomek = new User(
                    "tomek@gmail.com",
                    "$2a$10$chrySvbZSZcje4r3Q0PZv.FrO6/k2WvM42GX3x2EmySZc/dAA2glC"
            );

            repository.saveAll(
                    List.of(iza,andrzej,tomek)
            );
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
