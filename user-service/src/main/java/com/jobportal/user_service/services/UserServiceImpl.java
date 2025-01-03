package com.jobportal.user_service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jobportal.user_service.entities.User;
import com.jobportal.user_service.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public User saveUser(User user)throws Exception {
     user.getExperiences().forEach(experience -> experience.setUser(user));
     user.getEducations().forEach(education -> education.setUser(user));
     user.getSkills().forEach(skill -> skill.setUser(user));
     return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers(String isActive) throws Exception{
       return this.userRepository.findByIsActive(isActive);
    }

    @Override
    public User findByUserIdAndIsActive(Long userId, String isActive) throws Exception {
        return this.userRepository.findByUserIdAndIsActive(userId, isActive);
    }
}
