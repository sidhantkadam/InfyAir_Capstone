package com.sid.spring.capstone.InfyAir_Capstone.Service;

import com.sid.spring.capstone.InfyAir_Capstone.DTO.FlightDTO;
import com.sid.spring.capstone.InfyAir_Capstone.Entity.FlightEntity;
import com.sid.spring.capstone.InfyAir_Capstone.Exception.InfyAirException;
import com.sid.spring.capstone.InfyAir_Capstone.ModelMapper.ModelMapper;
import com.sid.spring.capstone.InfyAir_Capstone.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService
{
    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public FlightDTO createFlight(FlightDTO flightDTO)
    {
        FlightEntity flightEntity = modelMapper.flightDtoToEntity(flightDTO);
        flightRepository.save(flightEntity);
        return flightDTO;
    }

    @Override
    public FlightDTO getFlightDetails(Integer id) throws InfyAirException
    {
        FlightEntity flightEntity = flightRepository.findById(id)
                .orElseThrow(() -> new InfyAirException("Flight not present for this id: " + id));
        return modelMapper.flightEntityToDto(flightEntity);
    }

    @Override
    public FlightDTO updateFlight(Integer id, FlightDTO flightDTO)
    {
        return null;
    }

    @Override
    public List<FlightDTO> getAllFLightDetails(String source, String destination, LocalDateTime doj)
    {
        return List.of();
    }
}
