package com.sid.spring.capstone.InfyAir_Capstone.ModelMapper;

import com.sid.spring.capstone.InfyAir_Capstone.DTO.*;
import com.sid.spring.capstone.InfyAir_Capstone.Entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ModelMapper
{
    CustomerEntity customerDtoToCustomerEntity(CustomerDTO customerDTO);

    CustomerDTO customerEntityToCustomerDto(CustomerEntity customerEntity);

    AirportEntity airportDtoToEntity(AirportDTO airportDTO);

    AirportDTO airportEntityToDto(AirportEntity airportEntity);

    FlightEntity flightDtoToEntity(FlightDTO flightDTO);

    FlightDTO flightEntityToDto(FlightEntity flightEntity);

    BookingEntity bookingDTOToEntity(BookingDTO bookingDTO);

    BookingDTO bookingEntityToDto(BookingEntity bookingEntity);

    PassengerEntity passengerDTOToEntity(PassengerDTO passengerDTO);

    PassengerDTO passengerEntityToDto(PassengerEntity passengerEntity);
}
