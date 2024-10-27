package com.sid.spring.capstone.InfyAir_Capstone.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerDTO
{

    private String firstName;
    private String lastName;
    private Integer age;
    private char gender;
    private String city;
    private Long mobile;
    private String email;
    private String pass;
}
