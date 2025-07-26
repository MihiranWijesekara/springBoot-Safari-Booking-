package com.example.demo.service;

import com.example.demo.dto.Guide_Register_Request;
import com.example.demo.dto.Guide_Register_Response;

public interface GuideRegisterService {
    Guide_Register_Response guideRegister(Guide_Register_Request guide_Register_Request, Long userId);
}
