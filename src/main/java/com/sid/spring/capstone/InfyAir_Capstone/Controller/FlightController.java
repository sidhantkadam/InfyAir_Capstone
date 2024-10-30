package com.sid.spring.capstone.InfyAir_Capstone.Controller;

import com.sid.spring.capstone.InfyAir_Capstone.DTO.FlightDTO;
import com.sid.spring.capstone.InfyAir_Capstone.Exception.InfyAirException;
import com.sid.spring.capstone.InfyAir_Capstone.Service.FlightService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/flights")
public class FlightController
{
    @Autowired
    private FlightService flightService;

    @PostMapping("/createFlight")
    public ResponseEntity<FlightDTO> createFlight(@RequestBody @Valid FlightDTO flightDTO)
    {
        flightService.createFlight(flightDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(flightDTO);
    }

    @GetMapping("/flight/{id}")
    public ResponseEntity<FlightDTO> getFlightDetails(@PathVariable Integer id) throws InfyAirException
    {
        return ResponseEntity.status(HttpStatus.FOUND).body(flightService.getFlightDetails(id));
    }
}
