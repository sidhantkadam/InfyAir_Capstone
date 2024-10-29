package com.sid.spring.capstone.InfyAir_Capstone.Controller;

import com.sid.spring.capstone.InfyAir_Capstone.DTO.CustomerDTO;
import com.sid.spring.capstone.InfyAir_Capstone.Exception.InvalidUserException;
import com.sid.spring.capstone.InfyAir_Capstone.Exception.UserAlreadyPresent;
import com.sid.spring.capstone.InfyAir_Capstone.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController
{
    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<CustomerDTO> registerCustomer(@RequestBody CustomerDTO customerDTO) throws UserAlreadyPresent {
        customerService.registerCustomer(customerDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED).body(customerDTO);
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestHeader("username") String mobile, @RequestHeader("password") String pass) throws InvalidUserException
    {
        customerService.checkLogin(mobile, pass);
        return ResponseEntity.status(HttpStatus.FOUND).body("Login Successful !");
    }

    @GetMapping("/test")
    public String test()
    {
        return "Hello";
    }
}
