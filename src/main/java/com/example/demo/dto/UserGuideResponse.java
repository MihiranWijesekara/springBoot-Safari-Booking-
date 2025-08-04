package com.example.demo.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserGuideResponse {

    private String username;
    private int numberOfExperienceYears;
    private double hourlyRate;
    private String shortDescription;
}
