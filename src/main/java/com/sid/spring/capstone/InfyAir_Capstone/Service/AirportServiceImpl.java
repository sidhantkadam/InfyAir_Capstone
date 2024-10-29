package com.sid.spring.capstone.InfyAir_Capstone.Service;

import com.sid.spring.capstone.InfyAir_Capstone.DTO.AirportDTO;
import com.sid.spring.capstone.InfyAir_Capstone.Entity.AirportEntity;
import com.sid.spring.capstone.InfyAir_Capstone.ModelMapper.ModelMapper;
import com.sid.spring.capstone.InfyAir_Capstone.Repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirportServiceImpl implements AirportService
{
    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<AirportDTO> listAirports(AirportDTO airportDTO)
    {
        List<AirportDTO> result =  new ArrayList<>();
        airportRepository.findAll()
                .forEach(airportEntity ->
                        result.add(modelMapper.airportEntityToDto(airportEntity))
                );
        return result;
    }
}
