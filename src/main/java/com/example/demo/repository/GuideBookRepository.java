package com.example.demo.repository;

import com.example.demo.entity.GuideBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuideBookRepository extends JpaRepository<GuideBook, Long> {
    boolean existsByUser_IdAndBookingDate(Long userId, String bookingDate);
    List<GuideBook> findByUserId(Long userId);

}
