package com.example.demo.dto;


import com.example.demo.entity.User;
import lombok.Data;

@Data
public class GuideBookingRequest {
    private String fullName;
    private String nicNumber;
    private String mobileNumber;
    private String bookingDate;
    private Long userId;
}
