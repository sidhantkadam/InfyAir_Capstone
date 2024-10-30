package com.sid.spring.capstone.InfyAir_Capstone.Service;

import com.sid.spring.capstone.InfyAir_Capstone.DTO.CustomerDTO;
import com.sid.spring.capstone.InfyAir_Capstone.Exception.InvalidUserException;
import com.sid.spring.capstone.InfyAir_Capstone.Exception.InfyAirException;

public interface CustomerService
{
    CustomerDTO registerCustomer(CustomerDTO customerDTO) throws InfyAirException;

    CustomerDTO checkLogin(String mobile, String pass) throws InvalidUserException;
}
