package com.sid.spring.capstone.InfyAir_Capstone.Repository;

import com.sid.spring.capstone.InfyAir_Capstone.Entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer>
{

    Optional<CustomerEntity> findByMobile(String mobile);
}
