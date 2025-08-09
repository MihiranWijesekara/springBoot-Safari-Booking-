package com.example.demo.dto;

import lombok.Data;

@Data
public class UserSafariResponse {

    private String vehicleRegNumber;
    private double hourlyRate;
    private double fullDayServiceRate;
    private String vehicleType;
    private String Name;
}
