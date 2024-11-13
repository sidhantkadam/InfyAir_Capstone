package com.sid.spring.capstone.InfyAir_Capstone.DTO;

import com.sid.spring.capstone.InfyAir_Capstone.Entity.CustomerEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PassengerDTO
{
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private char gender;
    private String mobile;
    private CustomerEntity customerEntity;
}
