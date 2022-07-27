package com.store.restAPI.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("registration")
    public String getRegistration(){
        return "Register new user";
    }

    @PostMapping("registration")
    public String addNewUser(@RequestBody User user) {
        userService.addNewUser(user);
        return "redirect:login";
    }

    @GetMapping("login")
    public String getLogin(){
        return "Login to your account";
    }

    @PostMapping("login")
    public String loginUser(HttpSession session, @RequestBody User user){
        userService.loginUser(user);
        return session.getId();
    }
}
