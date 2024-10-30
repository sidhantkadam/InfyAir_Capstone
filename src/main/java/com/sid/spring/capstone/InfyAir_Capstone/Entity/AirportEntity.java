package com.sid.spring.capstone.InfyAir_Capstone.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="airport")
@NoArgsConstructor
public class AirportEntity
{
    @Id
    private String airportCode;
    private String airportName;
    private String cityName;

    public AirportEntity(String airportCode)
    {
        this.airportCode = airportCode;
    }
}
