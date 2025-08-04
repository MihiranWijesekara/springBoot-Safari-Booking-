package com.example.demo.service;

import com.example.demo.dto.UserGuideResponse;
import com.example.demo.dto.UserHotelResponse;

import java.util.List;

public interface UserService {

    List<UserHotelResponse> findAllHotels();
    List<UserGuideResponse> findAllGuides();


}
