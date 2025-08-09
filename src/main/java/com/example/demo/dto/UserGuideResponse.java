package com.example.demo.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserGuideResponse {

    private String Name;
//    private String firstName;
//    private String lastName;
    private int numberOfExperienceYears;
    private double hourlyRate;
    private String shortDescription;
}
