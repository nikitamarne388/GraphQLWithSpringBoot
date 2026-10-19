package com.learning.ecommerceApplication.controller;

import com.learning.ecommerceApplication.dto.UserInput;
import com.learning.ecommerceApplication.entities.User;
import com.learning.ecommerceApplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @QueryMapping
    public Optional<User> getUserById(@Argument Integer userId) {
        return userService.getUserById(userId);
    }

    @QueryMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @MutationMapping
    public User createUser(@Argument UserInput input){
        User user = new User(input.getName(),input.getEmail(),input.getPhone(),input.getPassword());
        return userService.createUser(user);
    }

    @MutationMapping
    public User updateUser(@Argument Integer userId, @Argument UserInput input){
        Optional<User> user = userService.getUserById(userId);

        if(user.isPresent()) {
            User userToBeUpdated = user.get();
            userToBeUpdated.setEmail(input.getEmail());
            userToBeUpdated.setName(input.getName());
            userToBeUpdated.setPhone(input.getPhone());
            userToBeUpdated.setPassword(input.getPassword());

            return userService.updateUserDetails(userToBeUpdated);
        }
        else{
            return null;
        }
    }

    @MutationMapping
    public Boolean deleteUser(@Argument Integer userId){
        return userService.deleteUser(userId);
    }
}
