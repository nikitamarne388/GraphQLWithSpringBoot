package com.learning.ecommerceApplication.services;

import com.learning.ecommerceApplication.entities.User;
import com.learning.ecommerceApplication.exceptions.ResourceNotFoundException;
import com.learning.ecommerceApplication.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    //creating user
    public User createUser(User user){
        return userRepo.save(user);
    }

    //getting all users
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    //getting single user
    public Optional<User> getUserById(Integer userId){
        User user = userRepo.findById(userId).orElseThrow(ResourceNotFoundException::throwResourceNotFoundException);;
        return Optional.of(user);
    }

    //updating user
    public User updateUserDetails(User user) {
        return userRepo.save(user);
    }

    //deleting user
    public boolean deleteUser(Integer userId) {
       User user = userRepo.findById(userId).orElseThrow(ResourceNotFoundException::throwResourceNotFoundException);
       userRepo.delete(user);
       return true;
    }

}
