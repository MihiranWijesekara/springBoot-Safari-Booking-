package com.example.demo.service.impl;

import com.example.demo.dto.Hotel_Register_Request;
import com.example.demo.dto.Hotel_Register_Response;
import com.example.demo.entity.HotelRegister;
import com.example.demo.entity.User;
import com.example.demo.repository.RegisterRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.RegisterService;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
    private final RegisterRepository hotelRegisterRepository;
    private final UserRepository userRepository;

    public RegisterServiceImpl(RegisterRepository hotelRegisterRepository,
                               UserRepository userRepository) {
        this.hotelRegisterRepository = hotelRegisterRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Hotel_Register_Response hotelRegister(Hotel_Register_Request request, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        // Activate the user
        user.setActive(true);
        userRepository.save(user);

        // Create and save the hotel registration
        HotelRegister hotelRegister = new HotelRegister();
        hotelRegister.setFullDayFee(request.getFullDayFee());
        hotelRegister.setNightFee(request.getNightFee());
        hotelRegister.setNumberOfRooms(request.getNumberOfRooms());
        hotelRegister.setAddress(request.getAddress());
        hotelRegister.setHotelName(request.getHotelName());
        hotelRegister.setUser(user);

        HotelRegister savedHotel = hotelRegisterRepository.save(hotelRegister);

        // Create and return the response
        Hotel_Register_Response response = new Hotel_Register_Response();
        response.setMessage("Hotel registered successfully");
        response.setHotelName(savedHotel.getHotelName());
        response.setUserId(userId);

        return response;
    }

}