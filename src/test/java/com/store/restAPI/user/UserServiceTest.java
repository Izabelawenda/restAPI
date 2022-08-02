package com.store.restAPI.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class UserServiceTest {

    private UserService underTest;
    @Mock
    private UserConfig userConfig;
    @Mock
    private  UserRepository userRepository;

    @BeforeEach
    void setUp(){
        underTest = new UserService(userRepository, userConfig);
    }

    @Test
    void itShouldFindAllUsers() {
        //when
        underTest.findAll();

        //then
        verify(userRepository).findAll();

    }

    @Test
    @Disabled
    void addNewUser() {
        //given
        User expected = new User(
                "mateusz@gmail.com",
                "123"
        );

        //when
        underTest.addNewUser(expected);

        //then
        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(userArgumentCaptor.capture());
        User capturedUser = userArgumentCaptor.getValue();
        assertThat(capturedUser).isEqualTo(expected);
    }

    @Test
    @Disabled
    void loginUser() {
        //given
        User expected = new User(
                "iza@gmail.com",
                "123"
        );

        //when
        underTest.addNewUser(expected);

        //then
        assertDoesNotThrow(() -> underTest.loginUser(expected));

    }

}