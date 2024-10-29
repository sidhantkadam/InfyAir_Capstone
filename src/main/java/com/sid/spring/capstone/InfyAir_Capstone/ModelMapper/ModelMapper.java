package com.sid.spring.capstone.InfyAir_Capstone.ModelMapper;

import com.sid.spring.capstone.InfyAir_Capstone.DTO.AirportDTO;
import com.sid.spring.capstone.InfyAir_Capstone.DTO.CustomerDTO;
import com.sid.spring.capstone.InfyAir_Capstone.Entity.AirportEntity;
import com.sid.spring.capstone.InfyAir_Capstone.Entity.CustomerEntity;
import org.hibernate.internal.util.StringHelper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ModelMapper
{
    CustomerEntity customerDtoToCustomerEntity(CustomerDTO customerDTO);

    CustomerDTO customerEntityToCustomerDto(CustomerEntity customerEntity);

    AirportEntity airportDtoToEntity(AirportDTO airportDTO);

    AirportDTO airportEntityToDto(AirportEntity airportEntity);
}
