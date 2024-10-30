package com.sid.spring.capstone.InfyAir_Capstone.Repository;

import com.sid.spring.capstone.InfyAir_Capstone.Entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, Integer>
{

}
