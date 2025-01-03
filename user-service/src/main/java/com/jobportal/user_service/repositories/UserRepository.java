package com.jobportal.user_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobportal.user_service.entities.User;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
    public User findByUserIdAndIsActive(Long userId, String isActive);

    public List<User> findByIsActive(String isActive);

}
