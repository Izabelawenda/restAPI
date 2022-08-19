package com.store.restAPI.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


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
        System.out.println(underTest.findAll());

        //then
        verify(userRepository).findAll();

    }

    @Test
    void addNewUser() {
        //given
        User expected = new User(
                "mateusz@gmail.com",
                "123"
        );

        //when
        Mockito.when(userConfig.passwordEncoder()).thenReturn(new BCryptPasswordEncoder());
        underTest.addNewUser(expected);

        //then
        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(userArgumentCaptor.capture());
        User capturedUser = userArgumentCaptor.getValue();
        assertThat(capturedUser).isEqualTo(expected);
    }

    @Test
    void loginUser() {
        //given
        User expected = new User(
                "iza@gmail.com",
                "123"
        );

        //when
        Mockito.when(userConfig.passwordEncoder()).thenReturn(new BCryptPasswordEncoder());
        underTest.addNewUser(expected);
        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(userArgumentCaptor.capture());
        User capturedUser = userArgumentCaptor.getValue();

        //then
        assertThat(capturedUser).isEqualTo(expected);
    }

}