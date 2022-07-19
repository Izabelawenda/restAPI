package com.store.restAPI.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserConfig userConfig;

    @Autowired
    public UserService(UserRepository userRepository, UserConfig userConfig) {
        this.userRepository = userRepository;
        this.userConfig = userConfig;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if(userOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        String hashedPassword = userConfig.passwordEncoder().encode(user.getPassword());
        user.setPassword(hashedPassword);
        userRepository.save(user);
    }

    public void loginUser(User user){
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if(userOptional.isEmpty()){
            throw new IllegalStateException("no account under that email");
        }
        else if(!userConfig.passwordEncoder().matches(user.getPassword(), userOptional.get().getPassword())){
            throw new IllegalStateException("wrong password");
        }
        //!userOptional.get().getPassword().equals(user.getPassword())
    }
}
