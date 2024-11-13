package com.sid.spring.capstone.InfyAir_Capstone.Repository;

import com.sid.spring.capstone.InfyAir_Capstone.Entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Integer>
{

}
