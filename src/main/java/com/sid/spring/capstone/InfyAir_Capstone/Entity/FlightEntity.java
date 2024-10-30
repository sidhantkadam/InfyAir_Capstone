package com.sid.spring.capstone.InfyAir_Capstone.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "flight")
public class FlightEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String company;
    private String flightNumber;
    private Integer duration;
    private Integer price;
    private Integer availableSeats;
    private LocalDateTime doj;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="source")
    private AirportEntity source;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="destination")
    private AirportEntity destination;
}
