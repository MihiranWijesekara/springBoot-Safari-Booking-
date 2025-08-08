package com.example.demo.repository;


import com.example.demo.entity.SafariVehicalBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SafariBookRepository  extends JpaRepository<SafariVehicalBook, Long> {
}
