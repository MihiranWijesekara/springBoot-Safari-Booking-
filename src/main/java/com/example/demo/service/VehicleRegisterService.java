package com.example.demo.service;


import com.example.demo.dto.Vehical_Register_Response;
import com.example.demo.dto.Vehicle_Register_Request;

public interface VehicleRegisterService {
    Vehical_Register_Response vehicleRegister(Vehicle_Register_Request vehicleRegisterRequest, Long userId);
}