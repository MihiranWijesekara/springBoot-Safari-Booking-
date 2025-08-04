package com.example.demo.repository;

import com.example.demo.dto.UserHotelResponse;
import com.example.demo.entity.GuideRegister;
import com.example.demo.entity.HotelRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisterRepository extends JpaRepository<HotelRegister, Long> {

}