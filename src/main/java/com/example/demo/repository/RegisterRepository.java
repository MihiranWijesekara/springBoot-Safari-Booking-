package com.example.demo.repository;

import com.example.demo.entity.HotelRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<HotelRegister, Long> {
}