package com.hello.demo.repository;

import com.hello.demo.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class UserRepository {

    private final List<User> users = new ArrayList<>(
            List.of(
                    new User(1L, "John Doe", "vannraruos@gmail.com", "password"),
                    new User(2L, "Jane Doe", "test@gmail.com", "password")
            )
    );

    private Long userIdCounter = 1L;

    public List<User> findAll() {
        System.out.println("User data"+users);
        return users;
    }


    public Optional<User> findById(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public User save (User user) {

        System.out.println("User data"+user);

        if(user.getId() == null){
            user.setId(userIdCounter++);
            user.setName(user.getName());
            user.setEmail(user.getEmail());
            user.setPassword(user.getPassword());
        }else {
            users.removeIf(existingUser -> existingUser.getId().equals(user.getId()));
            users.add(user);
        }

        return user;

    }

    public void deleteById(Long id) {
        users.removeIf(user -> user.getId().equals(id));
    }




}
