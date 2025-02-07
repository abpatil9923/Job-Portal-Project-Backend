package com.jobportal.user_service.services;

import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jobportal.user_service.Utils.UserUtils;
import com.jobportal.user_service.entities.User;
import com.jobportal.user_service.entities.UserLoginDetails;
import com.jobportal.user_service.repositories.UserLoginRepository;
import com.jobportal.user_service.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    private UserLoginRepository userLoginRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,UserLoginRepository userLoginRepository) {
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.userRepository = userRepository;
        this.userLoginRepository = userLoginRepository;
    }

    @Override
    @Transactional
    public User saveUser(User user)throws Exception {
     user.getExperiences().forEach(experience -> experience.setUser(user));
     user.getEducations().forEach(education -> education.setUser(user));
     user.getSkills().forEach(skill -> skill.setUser(user));

     UserLoginDetails userLoginDetails = new UserLoginDetails();

     userLoginDetails.setEmail(user.getUserEmail());
     userLoginDetails.setIsActive("Y");
     userLoginDetails.setAuthFaildCount(0);

    // Hash the password
    String hashedPassword = passwordEncoder.encode(UserUtils.getPassword());
    
    userLoginDetails.setPassword(hashedPassword);

     userLoginRepository.save(userLoginDetails);
        
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
