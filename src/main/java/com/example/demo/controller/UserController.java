package com.example.demo.controller;


import com.example.demo.dto.*;
import com.example.demo.entity.GuideBook;
import com.example.demo.entity.HotelBook;
import com.example.demo.entity.SafariVehicalBook;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hotels")
    public List<UserHotelResponse> getAllHotels() {
        return userService.findAllHotels();
    }

    @GetMapping("/guides")
    public List<UserGuideResponse> findAllGuides() {
        return userService.findAllGuides();
    }

    @GetMapping("/safari")
    public List<UserSafariResponse> findAllSafari() {
        return userService.findAllSafari();
    }

    @PostMapping("/guide-booking")
    public ResponseEntity<?> bookGuide( @RequestBody GuideBookingRequest bookingRequest) {
        try {
            GuideBook booking = userService.createGuideBooking(bookingRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(booking);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(
                    Map.of(
                            "error", "Booking failed",
                            "message", e.getMessage(),
                            "timestamp", LocalDateTime.now()
                    )
            );
        }
    }

    @PostMapping("/safari-booking")
    public ResponseEntity<?> bookSafari( @RequestBody SafariBookingRequest safariBookingRequest) {
        try {
            SafariVehicalBook Safaribooking = userService.createSafariBooking(safariBookingRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(Safaribooking);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(
                    Map.of(
                            "error", "Booking failed",
                            "message", e.getMessage(),
                            "timestamp", LocalDateTime.now()
                    )
            );
        }
    }

    @PostMapping("/hotel-booking")
    public ResponseEntity<?> bookHotel( @RequestBody HotelBookingRequest hotelBookingRequest) {
        try {
            HotelBook hotelbooking = userService.createHotelBooking(hotelBookingRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(hotelbooking);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(
                    Map.of(
                            "error", "Booking failed",
                            "message", e.getMessage(),
                            "timestamp", LocalDateTime.now()
                    )
            );
        }
    }

    @GetMapping("/user-guide-bookings")
    public ResponseEntity<List<GuideBookResponse>> getUserGuideBookings(
            @RequestParam Long userId) {

        List<GuideBookResponse> responses = userService.findAllBookingGuides(userId);
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/user-safari-bookings")
    public ResponseEntity<List<SafariBookingResponse>> getUserSafariBookings(
            @RequestParam Long userId) {

        List<SafariBookingResponse> responses = userService.findAllBookingSafari(userId);
        return ResponseEntity.ok(responses);
    }



}
