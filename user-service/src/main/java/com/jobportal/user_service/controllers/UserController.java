package com.jobportal.user_service.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.jobportal.user_service.entities.User;
import com.jobportal.user_service.exception.ResourceNotFoundException;
import com.jobportal.user_service.services.UserService;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/users")
public class UserController {

   private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/create")    
    public User createUser(@RequestBody User user) throws Exception{
        User userData = new User();
        try {
            userData = userService.saveUser(user);
        }
        catch(Exception exception){
            logger.error("error occurred in createUser of UserController : "+exception);
        }
        return userData;
    }

    @GetMapping   
    public List<User> getUsers(@RequestParam("isActive") String isActive) throws Exception{
        List<User> userData = new ArrayList<User>();
        try {
            userData = userService.getAllUsers(isActive);
        }
        catch(Exception exception){
            logger.error("error occurred in getUsers of UserController : "+ exception);
        }
        return userData;
    }


    @GetMapping("/get")    
    public User getUsers(@RequestParam("userId") Long userId,
     @RequestParam("isActive") String isActive) throws Exception{
        User user = new User();
        user = userService.findByUserIdAndIsActive(userId, isActive);
        if (user == null){
        throw new ResourceNotFoundException("User not found with ID: "+ userId);
        } 
       return user;
    }
}
