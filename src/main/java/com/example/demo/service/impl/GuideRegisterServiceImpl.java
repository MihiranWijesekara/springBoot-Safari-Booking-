package com.example.demo.service.impl;

import com.example.demo.dto.Guide_Register_Request;
import com.example.demo.dto.Guide_Register_Response;
import com.example.demo.entity.GuideRegister;
import com.example.demo.entity.User;
import com.example.demo.repository.GuideRegisterRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.GuideRegisterService;
import com.example.demo.service.RegisterService;
import org.springframework.stereotype.Service;

@Service
public class GuideRegisterServiceImpl implements GuideRegisterService {

    private final GuideRegisterRepository guideRegisterRepository;
    private final UserRepository userRepository;

    public GuideRegisterServiceImpl(GuideRegisterRepository guideRegisterRepository,
                                    UserRepository userRepository) {
        this.guideRegisterRepository = guideRegisterRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Guide_Register_Response guideRegister(Guide_Register_Request request, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        // Activate the user
        user.setActive(true);
        userRepository.save(user);

        // Create and save the guide registration
        GuideRegister guideRegister = new GuideRegister();
        guideRegister.setNumberOfExperienceYears(request.getNumberOfExperienceYears());
        guideRegister.setHourlyRate(request.getHourlyRate());
        guideRegister.setGuideRegNumber(request.getGuideRegNumber());
        guideRegister.setAge(request.getAge());
        guideRegister.setShortDescription(request.getShortDescription());
        guideRegister.setUser(user);

        GuideRegister savedGuide = guideRegisterRepository.save(guideRegister);

        // Create and return the response
        Guide_Register_Response response = new Guide_Register_Response();
        response.setMessage("Guide registered successfully");
        response.setUserId(userId);

        return response;
    }

}
