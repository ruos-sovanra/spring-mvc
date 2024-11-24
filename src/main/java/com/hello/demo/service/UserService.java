package com.hello.demo.service;

import com.hello.demo.model.User;
import com.hello.demo.service.dto.UserRequest;

import java.util.List;

public interface UserService {

    void createUser(UserRequest userRequest);

    List<User> getUsers();

    User findUserById(Long id);

    void updateUser(Long id, UserRequest userRequest);

    void deleteUser(Long id);

}
