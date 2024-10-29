package com.sid.spring.capstone.InfyAir_Capstone.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerDTO
{
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
