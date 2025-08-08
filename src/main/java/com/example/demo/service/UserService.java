package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.entity.GuideBook;
import com.example.demo.entity.HotelBook;
import com.example.demo.entity.SafariVehicalBook;

import java.util.List;

public interface UserService {

    List<UserHotelResponse> findAllHotels();
    List<UserGuideResponse> findAllGuides();
    List<UserSafariResponse> findAllSafari();

    GuideBook createGuideBooking(GuideBookingRequest bookingRequest);
    SafariVehicalBook createSafariBooking(SafariBookingRequest safariBookingRequest);
    HotelBook createHotelBooking(HotelBookingRequest hotelBookingRequest);

    List<GuideBookResponse> findAllBookingGuides(Long userId);
    List<SafariBookingResponse> findAllBookingSafari(Long userId);


}
