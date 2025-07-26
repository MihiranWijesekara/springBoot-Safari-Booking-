package com.example.demo.controller;


import com.example.demo.dto.Guide_Register_Request;
import com.example.demo.dto.Guide_Register_Response;
import com.example.demo.dto.Hotel_Register_Request;
import com.example.demo.dto.Hotel_Register_Response;
import com.example.demo.service.GuideRegisterService;
import com.example.demo.service.RegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/register")
public class Register {

    private final RegisterService registerService;
    private final GuideRegisterService guideRegisterService;

    public Register(RegisterService registerService,
                              GuideRegisterService guideRegisterService) {
        this.registerService = registerService;
        this.guideRegisterService = guideRegisterService;
    }

    @PostMapping("/hotel")
    public ResponseEntity<Hotel_Register_Response> registerHotel(
            @RequestBody Hotel_Register_Request request,
            @RequestParam Long userId) {

        Hotel_Register_Response response = registerService.hotelRegister(request, userId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/guide")
    public ResponseEntity<Guide_Register_Response> guideRegister(
            @RequestBody Guide_Register_Request request,
            @RequestParam Long userId) {

        Guide_Register_Response response = guideRegisterService.guideRegister (request, userId);
        return ResponseEntity.ok(response);
    }

}

