package com.sid.spring.capstone.InfyAir_Capstone.Controller;

import com.sid.spring.capstone.InfyAir_Capstone.DTO.FlightDTO;
import com.sid.spring.capstone.InfyAir_Capstone.Exception.InfyAirException;
import com.sid.spring.capstone.InfyAir_Capstone.Service.FlightService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
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

    @PutMapping("/updateFlight/{id}")
    public ResponseEntity<FlightDTO> updateFlight(@RequestBody @Valid FlightDTO flightDTO, @PathVariable Integer id) throws InfyAirException {
        flightService.updateFlight(id, flightDTO);
        return ResponseEntity.status(HttpStatus.OK).body(flightDTO);
    }

    @GetMapping("/allflights")
    public ResponseEntity<List<FlightDTO>> getAllFlightDetails(@RequestParam @Valid String source,
                                                               @RequestParam @Valid String destination,
                                                               @RequestParam @Valid LocalDate doj)
    {
        List<FlightDTO> allFlightDetails = flightService.getAllFlightDetails(source, destination, doj);
        return ResponseEntity.status( HttpStatus.FOUND).body(allFlightDetails);
    }

    @DeleteMapping("/deleteFlight/{id}")
    public ResponseEntity<String> deleteFlightById(@PathVariable Integer id) throws InfyAirException {
        flightService.deleteFlightById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Flight Deleted of Id: " + id);
    }
}