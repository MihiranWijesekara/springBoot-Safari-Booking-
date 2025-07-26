package com.example.demo.repository;

import com.example.demo.entity.GuideRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuideRegisterRepository extends JpaRepository<GuideRegister, Long> {
}