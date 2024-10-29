package com.sid.spring.capstone.InfyAir_Capstone.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Getter
@Setter
public class CustomerEntity
{
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private char gender;
    private String city;
    private String mobile;
    private String email;
    private String pass;
}
