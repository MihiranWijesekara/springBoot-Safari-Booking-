package com.example.demo.repository;


import com.example.demo.entity.GuideBook;
import com.example.demo.entity.HotelBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelBookRepository extends JpaRepository<HotelBook, Long> {

    List<HotelBook> findByUserId(Long userId);
}
