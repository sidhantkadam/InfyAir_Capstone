package com.sid.spring.capstone.InfyAir_Capstone.Service;

import com.sid.spring.capstone.InfyAir_Capstone.DTO.FlightDTO;
import com.sid.spring.capstone.InfyAir_Capstone.Entity.AirportEntity;
import com.sid.spring.capstone.InfyAir_Capstone.Entity.FlightEntity;
import com.sid.spring.capstone.InfyAir_Capstone.Exception.InfyAirException;
import com.sid.spring.capstone.InfyAir_Capstone.ModelMapper.ModelMapper;
import com.sid.spring.capstone.InfyAir_Capstone.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

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
    public FlightDTO updateFlight(Integer id, FlightDTO flightDTO) throws InfyAirException
    {
        flightRepository.findById(id)
                .orElseThrow(
                        ()-> new InfyAirException("Can't Update ! Flight not present for this id : " + id)
                );
        FlightEntity flightEntity = modelMapper.flightDtoToEntity(flightDTO);
        flightEntity.setId(id);
        flightRepository.save(flightEntity);
        return flightDTO;
    }

    @Override
    public List<FlightDTO> getAllFlightDetails(String source, String destination, LocalDate doj)
    {
        AirportEntity sourceEntity = new AirportEntity();
        sourceEntity.setAirportCode(source);

        AirportEntity destinationEntity = new AirportEntity();
        destinationEntity.setAirportCode(destination);

        List<FlightEntity> flightList = flightRepository
                .findBySourceAndDestinationAndDojBetween(
                        sourceEntity,
                        destinationEntity,
                        doj.atStartOfDay(),
                        doj.plusDays(1).atStartOfDay()
                );

        return flightList
                .stream()
                .map(modelMapper :: flightEntityToDto)
                .toList();
    }

    @Override
    public void deleteFlightById(Integer id) throws InfyAirException
    {
        flightRepository.findById(id)
                .orElseThrow(() -> new InfyAirException("Flight not present for this Id : " +  id));
        flightRepository.deleteById(id);
    }
}
