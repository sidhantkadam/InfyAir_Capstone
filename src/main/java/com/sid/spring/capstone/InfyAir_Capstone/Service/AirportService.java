package com.sid.spring.capstone.InfyAir_Capstone.Service;

import com.sid.spring.capstone.InfyAir_Capstone.DTO.AirportDTO;
import java.util.List;

public interface AirportService
{
    List<AirportDTO> listAirports(AirportDTO airportDTO);
}
