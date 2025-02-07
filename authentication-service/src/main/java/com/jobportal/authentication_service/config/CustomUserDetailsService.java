package com.jobportal.authentication_service.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.jobportal.authentication_service.entities.UserLoginDetails;
import com.jobportal.authentication_service.repositories.UserDetailsRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired
    private UserDetailsRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserLoginDetails> credential = repository.findByEmail(username);
        return credential.map(CustomUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("user not found with name :" + username));
    }
}
