package com.sid.spring.capstone.InfyAir_Capstone.Repository;

import com.sid.spring.capstone.InfyAir_Capstone.Entity.AirportEntity;
import com.sid.spring.capstone.InfyAir_Capstone.Entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, Integer>
{
    List<FlightEntity> findBySourceAndDestinationAndDojBetween(AirportEntity source, AirportEntity destination, LocalDateTime start, LocalDateTime end);
}
