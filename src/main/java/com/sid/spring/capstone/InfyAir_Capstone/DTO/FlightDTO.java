package com.sid.spring.capstone.InfyAir_Capstone.DTO;

import com.sid.spring.capstone.InfyAir_Capstone.Entity.AirportEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class FlightDTO
{
    private Integer id;
    private String company;
    private String flightNumber;
    private Integer duration;
    private Integer price;
    private Integer availableSeats;
    private LocalDateTime doj;
    private AirportEntity source;
    private AirportEntity destination;
}
