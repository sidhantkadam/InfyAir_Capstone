package com.sid.spring.capstone.InfyAir_Capstone.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "booking")
public class BookingEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime bookingTime;
    private Integer numberOfSeats;
    private String pnr;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;
    @ManyToOne
    @JoinColumn(name = "flight_id")
    private FlightEntity flightEntity;
    @OneToOne
    @JoinColumn(name = "payment_id")
    private PaymentEntity paymentEntity;

    @ManyToMany(cascade = CascadeType.REMOVE)
    private List<PassengerEntity> passengers;
}
