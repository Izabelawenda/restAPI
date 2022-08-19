package com.store.restAPI.user;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private  UserRepository underTest;

    @Test
    @Disabled
    void itShouldFindUserByEmail() {
        //given
        User expected = new User(
                "ktos@gmail.com",
                "123"
        );
        underTest.save(expected);

        //when
        Optional<User> outcome = underTest.findUserByEmail(expected.getEmail());

        //then
        assertEquals(expected, outcome.get());
    }
}