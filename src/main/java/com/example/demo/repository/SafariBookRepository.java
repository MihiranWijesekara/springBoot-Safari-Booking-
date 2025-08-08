package com.example.demo.repository;


import com.example.demo.entity.GuideBook;
import com.example.demo.entity.SafariVehicalBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SafariBookRepository  extends JpaRepository<SafariVehicalBook, Long> {

    List<SafariVehicalBook> findByUserId(Long userId);
}
