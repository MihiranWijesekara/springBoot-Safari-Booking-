package com.example.demo.service;

import com.example.demo.dto.Hotel_Register_Request;
import com.example.demo.dto.Hotel_Register_Response;

public interface RegisterService {
    Hotel_Register_Response hotelRegister(Hotel_Register_Request hotel_Register_Request, Long userId);

}
