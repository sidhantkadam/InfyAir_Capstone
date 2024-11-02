package com.sid.spring.capstone.InfyAir_Capstone.Service;

import com.sid.spring.capstone.InfyAir_Capstone.DTO.FlightDTO;
import com.sid.spring.capstone.InfyAir_Capstone.Exception.InfyAirException;
import java.time.LocalDate;
import java.util.List;

public interface FlightService
{
    FlightDTO createFlight(FlightDTO flightDTO);

    FlightDTO getFlightDetails(Integer id) throws InfyAirException;

    FlightDTO updateFlight(Integer id, FlightDTO flightDTO) throws InfyAirException;

    List<FlightDTO> getAllFlightDetails(String source, String destination, LocalDate doj);

    void deleteFlightById(Integer id) throws InfyAirException;
}
