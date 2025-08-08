package com.example.demo.dto;


import lombok.Data;

@Data
public class SafariBookingRequest {
    private String fullName;
    private String nicNumber;
    private String mobileNumber;
    private String bookingDate;
    private Long userId;
}
