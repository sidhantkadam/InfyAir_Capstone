package com.sid.spring.capstone.InfyAir_Capstone.DTO;

import com.sid.spring.capstone.InfyAir_Capstone.Entity.CustomerEntity;
import com.sid.spring.capstone.InfyAir_Capstone.Entity.FlightEntity;
import com.sid.spring.capstone.InfyAir_Capstone.Entity.PassengerEntity;
import com.sid.spring.capstone.InfyAir_Capstone.Entity.PaymentEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class BookingDTO
{
    private Integer id;
    private LocalDateTime bookingTime;
    private Integer numberOfSeats;
    private String pnr;
    private CustomerEntity customerEntity;
    private FlightEntity flightEntity;
    private PaymentEntity paymentEntity;
    private List<PassengerEntity> passengers;
}
