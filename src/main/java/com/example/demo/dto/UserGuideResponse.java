package com.example.demo.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserGuideResponse {

    private Long guideId;
    private String Name;
    private int numberOfExperienceYears;
    private double hourlyRate;
    private String shortDescription;
}
