package com.example.demo.controller;


import com.example.demo.dto.*;
import com.example.demo.service.GuideRegisterService;
import com.example.demo.service.RegisterService;
import com.example.demo.service.VehicleRegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/register")
public class Register {

    private final RegisterService registerService;
    private final GuideRegisterService guideRegisterService;
    private final VehicleRegisterService vehicleRegisterService;

    public Register(RegisterService registerService,
                              GuideRegisterService guideRegisterService, VehicleRegisterService vehicalRegisterService) {
        this.registerService = registerService;
        this.guideRegisterService = guideRegisterService;
        this.vehicleRegisterService = vehicalRegisterService;
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

    @PostMapping("/vehicle")
    public ResponseEntity<Vehical_Register_Response> registerVehicle(
            @RequestBody Vehicle_Register_Request request,
            @RequestParam Long userId) {

        Vehical_Register_Response response = vehicleRegisterService.vehicleRegister(request, userId);
        return ResponseEntity.ok(response);
    }

}


