package com.example.demo.service.impl;

import com.example.demo.dto.Vehical_Register_Response;
import com.example.demo.dto.Vehicle_Register_Request;
import com.example.demo.entity.User;
import com.example.demo.entity.VehicleRegister;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VehicleRegisterRepository;
import com.example.demo.service.VehicleRegisterService;
import org.springframework.stereotype.Service;

@Service
public class VehicleRegisterServiceImpl implements VehicleRegisterService {

    private final VehicleRegisterRepository vehicleRegisterRepository;
    private final UserRepository userRepository;

    public VehicleRegisterServiceImpl(VehicleRegisterRepository vehicleRegisterRepository,
                                      UserRepository userRepository) {
        this.vehicleRegisterRepository = vehicleRegisterRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Vehical_Register_Response vehicleRegister(Vehicle_Register_Request request, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        // Activate the user
        user.setActive(true);
        userRepository.save(user);

        // Create and save the vehicle registration
        VehicleRegister vehicleRegister = new VehicleRegister();
        vehicleRegister.setVehicleRegNumber(request.getVehicleRegNumber());
        vehicleRegister.setHourlyRate(request.getHourlyRate());
        vehicleRegister.setFullDayServiceRate(request.getFullDayServiceRate());
        vehicleRegister.setVehicleType(request.getVehicleType());
        vehicleRegister.setNumberOfTourists(request.getNumberOfTourists());
        vehicleRegister.setUser(user);

        VehicleRegister savedVehicle = vehicleRegisterRepository.save(vehicleRegister);

        // Create and return the response
        Vehical_Register_Response response = new Vehical_Register_Response();
        response.setMessage("Vehicle registered successfully");
        response.setUserId(userId);

        return response;
    }
}