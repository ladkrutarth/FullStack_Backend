package com.SpringbootProject.FullStack_Project.controller;


import com.SpringbootProject.FullStack_Project.exception.UserNotFoundExpception;
import com.SpringbootProject.FullStack_Project.model.User;
import com.SpringbootProject.FullStack_Project.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser)
    {
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    List<User>getall()
    {
        return userRepository.findAll();
    }
    @GetMapping("/user/{id}")
    User getUserId(@PathVariable Long id)
    {
        return userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundExpception(id));
    }
    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id)
    {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());

                    return userRepository.save(user);
                }).orElseThrow(()->new UserNotFoundExpception(id));
    }
    @DeleteMapping("/user/{id}")
    String deletUser(@PathVariable Long id)
    {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundExpception(id);
        }
        userRepository.deleteById(id);
        return "user with id"+ id + "has been deleted";


    }

}
