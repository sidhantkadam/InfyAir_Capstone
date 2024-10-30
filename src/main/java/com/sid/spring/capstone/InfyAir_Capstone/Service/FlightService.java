package com.sid.spring.capstone.InfyAir_Capstone.Service;

import com.sid.spring.capstone.InfyAir_Capstone.DTO.FlightDTO;
import com.sid.spring.capstone.InfyAir_Capstone.Exception.InfyAirException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FlightService
{
    FlightDTO createFlight(FlightDTO flightDTO);

    FlightDTO getFlightDetails(Integer id) throws InfyAirException;

    FlightDTO updateFlight(Integer id, FlightDTO flightDTO) throws InfyAirException;

    List<FlightDTO> getAllFLightDetails(String source, String destination, LocalDateTime doj);
}
