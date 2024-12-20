package com.sid.spring.capstone.InfyAir_Capstone.Service;

import com.sid.spring.capstone.InfyAir_Capstone.DTO.CustomerDTO;
import com.sid.spring.capstone.InfyAir_Capstone.Entity.CustomerEntity;
import com.sid.spring.capstone.InfyAir_Capstone.Exception.InvalidUserException;
import com.sid.spring.capstone.InfyAir_Capstone.Exception.InfyAirException;
import com.sid.spring.capstone.InfyAir_Capstone.ModelMapper.ModelMapper;
import com.sid.spring.capstone.InfyAir_Capstone.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService
{
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CustomerDTO registerCustomer(CustomerDTO customerDTO) throws InfyAirException {
        CustomerEntity checkEntity = modelMapper.customerDtoToCustomerEntity(customerDTO);
        customerRepository.findByMobile(checkEntity.getMobile())
                .orElseThrow(() -> new InfyAirException("User Already Registered with " + checkEntity.getMobile() + " this mobile"));
        customerRepository.save(checkEntity);
        return customerDTO;
    }

    @Override
    public CustomerDTO checkLogin(String mobile, String pass) throws InvalidUserException
    {
        Optional<CustomerEntity> checkCustomer = customerRepository.findByMobile(mobile);
        if(checkCustomer.isPresent() && checkCustomer.get().getPass().equals(pass))
        {
            return modelMapper.customerEntityToCustomerDto(checkCustomer.get());
        }
        throw new InvalidUserException("user name and password not matched for " + checkCustomer.get().getMobile() + " this mobile" );
    }
}
