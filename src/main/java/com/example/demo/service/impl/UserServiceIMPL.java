package com.example.demo.service.impl;

import com.example.demo.dto.*;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    private RegisterRepository registerRepository;

    @Autowired
    private GuideRegisterRepository guideRegisterRepository;

    @Autowired
    private VehicleRegisterRepository vehicleRegisterRepository;

    @Autowired
    private GuideBookRepository guideBookRepository;

    @Autowired
    private SafariBookRepository safariBookRepository;

    @Autowired
    private HotelBookRepository hotelBookRepository;

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
        List<GuideRegister> guides = guideRegisterRepository.findAll();

        return guides.stream()
                .map(this::convertToUserGuideResponse)
                .collect(Collectors.toList());// Assuming you have a method to fetch guides
    }

    @Override
    public List<UserSafariResponse> findAllSafari() {
        List<VehicleRegister> safari = vehicleRegisterRepository.findAll();

        return safari.stream()
                .map(this::convertToUserSafariResponse)
                .collect(Collectors.toList());

    }


    private UserHotelResponse convertToUserHotelResponse(HotelRegister hotel) {
        UserHotelResponse response = new UserHotelResponse();
        response.setFullDayFee(hotel.getFullDayFee());
        response.setNightFee(hotel.getNightFee());
        response.setHotelName(hotel.getHotelName()); // Assuming the field is called 'name' in HotelRegister
        response.setHotelId(hotel.getUser().getId());

        // Map any additional fields if needed
        return response;
    }

    private UserGuideResponse convertToUserGuideResponse(GuideRegister guide) {
        UserGuideResponse response = new UserGuideResponse();
        response.setNumberOfExperienceYears(guide.getNumberOfExperienceYears());
        response.setHourlyRate(guide.getHourlyRate());
        response.setShortDescription(guide.getShortDescription());
        response.setGuideId(guide.getUser().getId());

        // Combine first and last name
        String fullName = guide.getUser().getFirstName() + " " + guide.getUser().getLastName();
        response.setName(fullName);  // Assuming you have a setName method in UserGuideResponse

        return response;
    }

    private UserSafariResponse convertToUserSafariResponse(VehicleRegister vehical) {
        UserSafariResponse response = new UserSafariResponse();

        response.setVehicleRegNumber(vehical.getVehicleRegNumber());
        response.setHourlyRate(vehical.getHourlyRate());
        response.setFullDayServiceRate(vehical.getFullDayServiceRate());
        response.setVehicleType(vehical.getVehicleType());
        response.setSafariId(vehical.getUser().getId());

        // Combine first and last name
        String fullName = vehical.getUser().getFirstName() + " " + vehical.getUser().getLastName();
        response.setName(fullName);

        return response;
    }

    @Override
    public GuideBook createGuideBooking(GuideBookingRequest bookingRequest) {
        // Validate date is in the future
        LocalDate bookingDate = LocalDate.parse(bookingRequest.getBookingDate());
        if (bookingDate.isBefore(LocalDate.now())) {
            throw new RuntimeException("Cannot book for past dates");
        }

        GuideBook booking = new GuideBook();
        booking.setFullName(bookingRequest.getFullName());
        booking.setNicNumber(bookingRequest.getNicNumber());
        booking.setMobileNumber(bookingRequest.getMobileNumber());
        booking.setBookingDate(bookingRequest.getBookingDate());


        if (bookingRequest.getUserId() != null) {
            User user = userRepository.findById(bookingRequest.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            booking.setUser(user);
        }

        return guideBookRepository.save(booking);
    }

    @Override
    public SafariVehicalBook createSafariBooking(SafariBookingRequest safariBookingRequest) {
        // Validate date is in the future
        LocalDate bookingDate = LocalDate.parse(safariBookingRequest.getBookingDate());
        if (bookingDate.isBefore(LocalDate.now())) {
            throw new RuntimeException("Cannot book for past dates");
        }

        SafariVehicalBook booking = new SafariVehicalBook();
        booking.setFullName(safariBookingRequest.getFullName());
        booking.setNicNumber(safariBookingRequest.getNicNumber());
        booking.setMobileNumber(safariBookingRequest.getMobileNumber());
        booking.setBookingDate(safariBookingRequest.getBookingDate());

        if (safariBookingRequest.getUserId() != null) {
            User user = userRepository.findById(safariBookingRequest.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            booking.setUser(user);
        }

        return safariBookRepository.save(booking);
    }

    @Override
    public HotelBook createHotelBooking(HotelBookingRequest hotelBookingRequest) {
        // Validate date is in the future
        LocalDate bookingDate = LocalDate.parse(hotelBookingRequest.getBookingDate());
        if (bookingDate.isBefore(LocalDate.now())) {
            throw new RuntimeException("Cannot book for past dates");
        }

        HotelBook booking = new HotelBook();
        booking.setFullName(hotelBookingRequest.getFullName());
        booking.setNicNumber(hotelBookingRequest.getNicNumber());
        booking.setMobileNumber(hotelBookingRequest.getMobileNumber());
        booking.setBookingDate(hotelBookingRequest.getBookingDate());

        // Set boolean values for fullDay and night options
        booking.setFullDayFee(hotelBookingRequest.getFullDayFee() == 1);
        booking.setNightFee(hotelBookingRequest.getNightFee() == 1);

        if (hotelBookingRequest.getUserId() != null) {
            User user = userRepository.findById(hotelBookingRequest.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            booking.setUser(user);
        }

        return hotelBookRepository.save(booking);
    }

    @Override
    public List<GuideBookResponse> findAllBookingGuides(Long userId) {
        List<GuideBook> bookings = guideBookRepository.findByUserId(userId);

        return bookings.stream()
                .map(booking -> {
                    GuideBookResponse response = new GuideBookResponse();
                    response.setFullName(booking.getFullName());
                    response.setNicNumber(booking.getNicNumber());
                    response.setMobileNumber(booking.getMobileNumber());
                    response.setBookingDate(booking.getBookingDate().toString()); // format as needed
                    return response;
                })
                .collect(Collectors.toList());

    }

    @Override
    public List<SafariBookingResponse> findAllBookingSafari(Long userId) {
        List<SafariVehicalBook> bookings = safariBookRepository.findByUserId(userId);

        return bookings.stream()
                .map(booking -> {
                    SafariBookingResponse response = new SafariBookingResponse();
                    response.setFullName(booking.getFullName());
                    response.setNicNumber(booking.getNicNumber());
                    response.setMobileNumber(booking.getMobileNumber());
                    response.setBookingDate(booking.getBookingDate().toString()); // format as needed
                    return response;
                })
                .collect(Collectors.toList());

    }

    @Override
    public List<HotelBookingResponse> findAllBookingHotel(Long userId) {
        List<HotelBook> bookings = hotelBookRepository.findByUserId(userId);

        return bookings.stream()
                .map(booking -> {
                    HotelBookingResponse response = new HotelBookingResponse();
                    response.setFullName(booking.getFullName());
                    response.setNicNumber(booking.getNicNumber());
                    response.setMobileNumber(booking.getMobileNumber());
                    response.setBookingDate(booking.getBookingDate().toString());

                    // Set fees directly from the booking
                    response.setFullDayFee(booking.isFullDayFee() ? 1 : 0);
                    response.setNightFee(booking.isNightFee() ? 1 : 0);

                    // Calculate booking type (1 for full day, 0 for night)
                    int bookingType = booking.isFullDayFee() ? 1 : 0;
                    response.setBookingType(bookingType);

                    return response;
                })
                .collect(Collectors.toList());
    }

}
