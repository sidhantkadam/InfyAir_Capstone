package com.sid.spring.capstone.InfyAir_Capstone.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="airport")
@Getter
@Setter
public class AirportEntity
{
    @Id
    private String airportCode;
    private String airportName;
    private String cityName;
}
