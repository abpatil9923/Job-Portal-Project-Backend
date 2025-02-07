package com.jobportal.authentication_service.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobportal.authentication_service.entities.UserLoginDetails;

public interface UserDetailsRepository extends JpaRepository<UserLoginDetails, Long>{
    
    Optional<UserLoginDetails> findByEmail(String email);
}
