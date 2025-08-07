package com.example.demo.service.impl;

import com.example.demo.dto.GuideBookingRequest;
import com.example.demo.dto.UserGuideResponse;
import com.example.demo.dto.UserHotelResponse;
import com.example.demo.dto.UserSafariResponse;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    private  RegisterRepository registerRepository;

    @Autowired
    private  GuideRegisterRepository guideRegisterRepository;

    @Autowired
    private VehicleRegisterRepository vehicleRegisterRepository;

    @Autowired
    private GuideBookRepository guideBookRepository;

    @Autowired
    private UserRepository userRepository;

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

    @Override
    public List<UserSafariResponse> findAllSafari() {
        List <VehicleRegister> safari = vehicleRegisterRepository.findAll();

        return safari.stream()
                .map(this::convertToUserSafariResponse)
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

    private UserGuideResponse convertToUserGuideResponse(GuideRegister guide) {
        UserGuideResponse response = new UserGuideResponse();
        response.setNumberOfExperienceYears(guide.getNumberOfExperienceYears());
        response.setUsername(guide.getUser().getUsername());
        response.setHourlyRate(guide.getHourlyRate());
        response.setShortDescription(guide.getShortDescription());

        return response;
    }

    private UserSafariResponse convertToUserSafariResponse(VehicleRegister vehical) {
        UserSafariResponse response = new UserSafariResponse();

        response.setVehicleRegNumber(vehical.getVehicleRegNumber());
        response.setUsername(vehical.getUser().getUsername());
        response.setHourlyRate(vehical.getHourlyRate());
        response.setFullDayServiceRate(vehical.getFullDayServiceRate());
        response.setVehicleType(vehical.getVehicleType());

        return response;
    }

    @Override
    public GuideBook createGuideBooking(GuideBookingRequest bookingRequest) {
        // 1. Validate booking date is not in the past
        LocalDate bookingDate;
        try {
            bookingDate = LocalDate.parse(bookingRequest.getBookingDate());
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Invalid date format. Please use YYYY-MM-DD");
        }

        if (bookingDate.isBefore(LocalDate.now())) {
            throw new RuntimeException("Cannot book for past dates");
        }

        // 2. Check for existing booking for this user on this date
        if (bookingRequest.getUserId() != null) {
            boolean bookingExists = guideBookRepository.existsByUser_IdAndBookingDate(
                    bookingRequest.getUserId(),
                    bookingRequest.getBookingDate()
            );

            if (bookingExists) {
                throw new RuntimeException("You already have a booking for this date");
            }


        }

        // 3. Create new booking
        GuideBook booking = new GuideBook();
        booking.setFullName(bookingRequest.getFullName());
        booking.setNicNumber(bookingRequest.getNicNumber());
        booking.setMobileNumber(bookingRequest.getMobileNumber());
        booking.setBookingDate(bookingRequest.getBookingDate());

        User user = userRepository.findById(bookingRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        booking.setUser(user);

        return guideBookRepository.save(booking);
    }

}
