package com.sid.spring.capstone.InfyAir_Capstone.Service;

import com.sid.spring.capstone.InfyAir_Capstone.DTO.BookingDTO;
import com.sid.spring.capstone.InfyAir_Capstone.Exception.InfyAirException;
import com.sid.spring.capstone.InfyAir_Capstone.Exception.InvalidUserException;
import org.springframework.http.ResponseEntity;

public interface BookingService
{

    BookingDTO createBooking(String mobile, String pass, Integer customerId, BookingDTO bookingDTO) throws InfyAirException, InvalidUserException;
}
