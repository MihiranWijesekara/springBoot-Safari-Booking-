package com.example.demo.dto;

import lombok.Data;

@Data
public class UserHotelResponse {

    private Long hotelId;
    private int fullDayFee;
    private int nightFee;
    private String hotelName;
}
