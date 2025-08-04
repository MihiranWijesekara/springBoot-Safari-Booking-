package com.example.demo.service.impl;

import com.example.demo.dto.UserHotelResponse;
import com.example.demo.entity.HotelRegister;
import com.example.demo.repository.RegisterRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceIMPL implements UserService {

    private final RegisterRepository registerRepository;

    @Autowired
    public UserServiceIMPL(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    @Override
    public List<UserHotelResponse> findAllHotels() {
        List<HotelRegister> hotels = registerRepository.findAll();

        return hotels.stream()
                .map(this::convertToUserHotelResponse)
                .collect(Collectors.toList());
    }

    private UserHotelResponse convertToUserHotelResponse(HotelRegister hotel) {
        UserHotelResponse response = new UserHotelResponse();
        response.setFullDayFee(hotel.getFullDayFee());
        response.setNightFee(hotel.getNightFee());
        response.setHotelName(hotel.getHotelName()); // Assuming the field is called 'name' in HotelRegister

        // Map any additional fields if needed
        return response;
    }

}
