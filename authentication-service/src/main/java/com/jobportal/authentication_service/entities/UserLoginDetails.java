package com.jobportal.authentication_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loginDetailsId;

    private String email;

    private String password;

    private Integer authFaildCount;

    private String isActive;
    
}
