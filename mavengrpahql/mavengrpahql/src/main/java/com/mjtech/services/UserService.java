package com.mjtech.services;

import com.mjtech.entities.User;
import com.mjtech.helper.ExceptionHelper;
import com.mjtech.repositories.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    //creating User
    public User createUser(User user) {
        return userRepo.save(user);
    }
    //getting all users
    public List<User> getAllUser(){

        return userRepo.findAll();
    }
    //getting single user
    public User getUser(int userId){
        User user = userRepo.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        return user;
    }
    //deleting user
    public boolean deleteUser(int userId){
        User user = userRepo.findById(userId).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        userRepo.delete(user);
        return true;
    }
    //update user
    public boolean updateUser(User user) {
        // Fetch the existing user from the database
        User existingUser = userRepo.findById(user.getUserId())
                .orElseThrow(ExceptionHelper::throwResourceNotFoundException);

        // Update the fields that are not null in the incoming user object
        if (user.getName() != null) {
            existingUser.setName(user.getName());
        }
        if (user.getEmail() != null) {
            existingUser.setEmail(user.getEmail());
        }
        if (user.getPhone() != null) {
            existingUser.setPhone(user.getPhone());
        }
        if (user.getPassword() != null) {
            existingUser.setPassword(user.getPassword());
        }
        // Save the updated user object back to the database
        userRepo.save(existingUser);
        return true;
    }


}
