package com.example.demo.service.impl;

import com.example.demo.dto.UserGuideResponse;
import com.example.demo.dto.UserHotelResponse;
import com.example.demo.entity.GuideRegister;
import com.example.demo.entity.HotelRegister;
import com.example.demo.repository.GuideRegisterRepository;
import com.example.demo.repository.RegisterRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    private  RegisterRepository registerRepository;

    @Autowired
    private  GuideRegisterRepository guideRegisterRepository;

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

    @Override
    public List<UserGuideResponse> findAllGuides() {
        List <GuideRegister> guides = guideRegisterRepository.findAll();

        return guides.stream()
                .map(this::convertToUserGuideResponse)
                .collect(Collectors.toList());// Assuming you have a method to fetch guides
    }

    private UserHotelResponse convertToUserHotelResponse(HotelRegister hotel) {
        UserHotelResponse response = new UserHotelResponse();
        response.setFullDayFee(hotel.getFullDayFee());
        response.setNightFee(hotel.getNightFee());
        response.setHotelName(hotel.getHotelName()); // Assuming the field is called 'name' in HotelRegister

        // Map any additional fields if needed
        return response;
    }

    private UserGuideResponse convertToUserGuideResponse(GuideRegister guide) {
        UserGuideResponse response = new UserGuideResponse();
        response.setNumberOfExperienceYears(guide.getNumberOfExperienceYears());
        response.setUsername(guide.getUser().getUsername());
        response.setHourlyRate(guide.getHourlyRate());
        response.setShortDescription(guide.getShortDescription());

        // Map any additional fields if needed
        return response;
    }

}
