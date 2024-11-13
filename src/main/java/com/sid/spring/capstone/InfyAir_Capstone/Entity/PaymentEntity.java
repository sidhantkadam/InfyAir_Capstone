package com.sid.spring.capstone.InfyAir_Capstone.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "payment")
public class PaymentEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer amount;
    private LocalDateTime paymentTime;

    @OneToOne
    @JoinColumn(name = "booking_id")
    private BookingEntity bookingEntity;
}
