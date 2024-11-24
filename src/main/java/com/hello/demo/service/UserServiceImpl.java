package com.hello.demo.service;

import com.hello.demo.model.User;
import com.hello.demo.repository.UserRepository;
import com.hello.demo.service.dto.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;


    @Override
    public void createUser(UserRequest userRequest) {

        User user = new User();
        user.setName(userRequest.name());
        user.setEmail(userRequest.email());
        user.setPassword(userRequest.password());
        userRepository.save(user);

    }

    @Override
    public List<User> getUsers() {

        List<User> users = userRepository.findAll();

        return users;
    }

    @Override
    public User findUserById(Long id) {

        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        return user;

    }

    @Override
    public void updateUser(Long id, UserRequest userRequest) {

        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        user.setName(userRequest.name());
        user.setEmail(userRequest.email());
        user.setPassword(userRequest.password());
        userRepository.save(user);

    }

    @Override
    public void deleteUser(Long id) {

//        User user = userRepository.findById(id).orElse(null);
//
//        if (user == null) {
//            throw new RuntimeException("User not found");
//        }

        userRepository.deleteById(id);

    }
}
