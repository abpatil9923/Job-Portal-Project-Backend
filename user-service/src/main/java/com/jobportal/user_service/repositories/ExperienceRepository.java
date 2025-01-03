package com.jobportal.user_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobportal.user_service.entities.Experience;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    
}
