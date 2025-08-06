package com.example.demo.dto;

import lombok.Data;

@Data
public class Guide_Book_Register_Request {

    private String fullName;
    private String nicNumber;
    private String mobileNumber;
    private String bookingDate;

}
