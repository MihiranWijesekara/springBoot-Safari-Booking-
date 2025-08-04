package com.example.demo.controller;


import com.example.demo.dto.UserGuideResponse;
import com.example.demo.dto.UserHotelResponse;
import com.example.demo.dto.UserSafariResponse;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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


}
