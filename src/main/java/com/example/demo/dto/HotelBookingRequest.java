package com.example.demo.dto;

import lombok.Data;

@Data
public class HotelBookingRequest {
    private String fullName;
    private String nicNumber;
    private String mobileNumber;
    private String bookingDate;
    private int fullDayFee;
    private int nightFee;
    private Long userId;
}
