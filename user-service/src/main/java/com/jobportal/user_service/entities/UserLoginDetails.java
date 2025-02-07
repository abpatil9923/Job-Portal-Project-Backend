package com.jobportal.user_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loginDetailsId;

    private String email;

    private String password;

    private Integer authFaildCount;

    private String isActive;

}
