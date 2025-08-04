package com.example.demo.repository;

import com.example.demo.entity.VehicleRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRegisterRepository extends JpaRepository<VehicleRegister, Long> {
}
