package com.sid.spring.capstone.InfyAir_Capstone.Service;

import com.sid.spring.capstone.InfyAir_Capstone.DTO.BookingDTO;
import com.sid.spring.capstone.InfyAir_Capstone.DTO.PassengerDTO;
import com.sid.spring.capstone.InfyAir_Capstone.Entity.BookingEntity;
import com.sid.spring.capstone.InfyAir_Capstone.Entity.CustomerEntity;
import com.sid.spring.capstone.InfyAir_Capstone.Entity.FlightEntity;
import com.sid.spring.capstone.InfyAir_Capstone.Entity.PassengerEntity;
import com.sid.spring.capstone.InfyAir_Capstone.Exception.InfyAirException;
import com.sid.spring.capstone.InfyAir_Capstone.Exception.InvalidUserException;
import com.sid.spring.capstone.InfyAir_Capstone.ModelMapper.ModelMapper;
import com.sid.spring.capstone.InfyAir_Capstone.ModelMapper.ModelMapperImpl;
import com.sid.spring.capstone.InfyAir_Capstone.Repository.BookingRepository;
import com.sid.spring.capstone.InfyAir_Capstone.Repository.CustomerRepository;
import com.sid.spring.capstone.InfyAir_Capstone.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class BookingServiceImpl implements BookingService
{
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BookingDTO createBooking(String mobile, String pass, Integer customerId, BookingDTO bookingDTO) throws InvalidUserException, InfyAirException
    {
        //Check for login using mobile and password
        customerService.checkLogin(mobile, pass);

        //Checking for Customer
        CustomerEntity customerEntity = customerRepository.findById(customerId)
                .orElseThrow(()-> new InfyAirException("Customer does not Exist !"));

        //Checking for Flight
        FlightEntity flightEntity = flightRepository.findById(bookingDTO.getFlightEntity().getId())
                .orElseThrow(() -> new InfyAirException("Flight does not Exist !"));

        BookingEntity bookingEntity = modelMapper.bookingDTOToEntity(bookingDTO);

        //Setting booking customer
        modelMapper.bookingDTOToEntity(bookingDTO).setCustomerEntity(customerEntity);

        //Setting booking flight
        modelMapper.bookingDTOToEntity(bookingDTO).setFlightEntity(flightEntity);

        //Set booking passenger
        ModelMapper modelMapper = new ModelMapperImpl();
        List<PassengerEntity> passengerEntities = bookingDTO
                .getPassengers()
                .stream()
                .map(passengerDTO -> modelMapper.passengerDTOToEntity((PassengerDTO) bookingDTO.getPassengers()))
                .toList();

        passengerEntities.forEach(passengerEntity -> passengerEntity.setCustomerEntity(customerEntity));

        bookingEntity.setPassengers(passengerEntities);

        bookingEntity = bookingRepository.save(bookingEntity);
        bookingDTO.setId(bookingEntity.getId());
        return bookingDTO;
    }
}
