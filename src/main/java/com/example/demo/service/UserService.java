package com.example.demo.service;

import com.example.demo.dto.GuideBookingRequest;
import com.example.demo.dto.UserGuideResponse;
import com.example.demo.dto.UserHotelResponse;
import com.example.demo.dto.UserSafariResponse;
import com.example.demo.entity.GuideBook;

import java.util.List;

public interface UserService {

    List<UserHotelResponse> findAllHotels();
    List<UserGuideResponse> findAllGuides();
    List<UserSafariResponse> findAllSafari();

    GuideBook createGuideBooking(GuideBookingRequest bookingRequest);


}
