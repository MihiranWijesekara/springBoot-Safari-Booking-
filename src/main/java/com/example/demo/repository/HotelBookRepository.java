package com.example.demo.repository;


import com.example.demo.entity.HotelBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelBookRepository extends JpaRepository<HotelBook, Long> {
}
