package com.jobportal.user_service.services;

import java.util.List;

import com.jobportal.user_service.entities.User;

public interface UserService {
    
    public User saveUser(User user) throws Exception;

    public List<User> getAllUsers(String isActive) throws Exception;

    public User findByUserIdAndIsActive(Long userId, String isActive) throws Exception;
}
