package com.sid.spring.capstone.InfyAir_Capstone.Controller;

import com.sid.spring.capstone.InfyAir_Capstone.DTO.BookingDTO;
import com.sid.spring.capstone.InfyAir_Capstone.Exception.InfyAirException;
import com.sid.spring.capstone.InfyAir_Capstone.Exception.InvalidUserException;
import com.sid.spring.capstone.InfyAir_Capstone.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/{customerId}/bookings")
public class BookingController
{
    @Autowired
    BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingDTO> createBooking(@RequestHeader String mobile,
                                                    @RequestHeader String pass,
                                                    @PathVariable Integer customerId,
                                                    @RequestBody BookingDTO bookingDTO) throws InfyAirException, InvalidUserException 
    {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(bookingService.createBooking(mobile,pass,customerId,bookingDTO));
    }
}
