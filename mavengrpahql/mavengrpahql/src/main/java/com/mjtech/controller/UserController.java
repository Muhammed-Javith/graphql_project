package com.mjtech.controller;

import com.mjtech.entities.Order;
import com.mjtech.entities.User;
import com.mjtech.services.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    //create user api
    //@MutationMapping(name="createUser")
    @MutationMapping
    public User createUser(@Argument String name, @Argument String email, @Argument String phone, @Argument String password) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
        return userService.createUser(user);
    }
    //get Users
    @QueryMapping(name = "getUsers")
    public List<User> getAllUsers(){
        List<User> users = userService.getAllUser();
        return users;
    }
    //get Single user;
    @QueryMapping
    public User getUser(@Argument int userId) {
        return userService.getUser(userId);
    }
    //delete user
    //@SchemaMapping(typeName = "Mutation", field="deleteUser")
    @MutationMapping
    public boolean deleteUser(@Argument int userId) {
        return userService.deleteUser(userId);
    }
    //update user
    @MutationMapping
    public boolean updateUser(@Argument int userId,@Argument String name, @Argument String email, @Argument String phone, @Argument String password) {
        User user = new User();
        user.setUserId(userId);
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
        return userService.updateUser(user);
    }

}
