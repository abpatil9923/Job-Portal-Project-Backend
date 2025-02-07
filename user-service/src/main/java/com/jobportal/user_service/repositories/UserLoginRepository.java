package com.jobportal.user_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobportal.user_service.entities.UserLoginDetails;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLoginDetails, Long>{
}
