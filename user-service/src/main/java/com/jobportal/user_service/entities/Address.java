package com.jobportal.user_service.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @Column(name = "address_line_1")
    private String addressLine1;
    
    @Column(name = "address_line_2")
    private String addressLine2;

    @Column(name = "address_line_3")
    private String addressLine3;

    private String city;

    private String state;

    private String county;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "is_active")
    private String isActive;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private User user;

    public Address(String addressLine1, String addressLine2, String addressLine3, String city, String state,
            String county, String zipCode, String isActive) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.city = city;
        this.state = state;
        this.county = county;
        this.zipCode = zipCode;
        this.isActive = isActive;
    }
    
}
