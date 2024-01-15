package com.environment.environmentDataAnalysis.Service;

import com.environment.environmentDataAnalysis.Repository.AirQualityRepository;
import com.environment.environmentDataAnalysis.ServiceInterface.AirQualityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AirQualityServiceImpl implements AirQualityService {
    private AirQualityRepository airQualityRepository;


}
