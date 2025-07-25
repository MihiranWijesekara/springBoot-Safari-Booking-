package com.example.demo.controller;


import com.example.demo.dto.Hotel_Register_Request;
import com.example.demo.dto.Hotel_Register_Response;
import com.example.demo.service.RegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/register")
public class Register {

    private final RegisterService registerService;

    public Register(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/hotel")
    public ResponseEntity<Hotel_Register_Response> registerHotel(
            @RequestBody Hotel_Register_Request request,
            @RequestParam Long userId) {

        Hotel_Register_Response response = registerService.hotelRegister(request, userId);
        return ResponseEntity.ok(response);
    }
}
