package com.sid.spring.capstone.InfyAir_Capstone.Controller;

import com.sid.spring.capstone.InfyAir_Capstone.DTO.AirportDTO;
import com.sid.spring.capstone.InfyAir_Capstone.Service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/airports")
public class AirportController
{
    @Autowired
    private AirportService airportService;

    @GetMapping
    public ResponseEntity<List<AirportDTO>> listOfAirports(AirportDTO airportDTO)
    {
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(airportService.listAirports(airportDTO));
    }
}
