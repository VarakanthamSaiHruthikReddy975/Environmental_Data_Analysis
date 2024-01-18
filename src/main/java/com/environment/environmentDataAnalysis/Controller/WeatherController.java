package com.environment.environmentDataAnalysis.Controller;

import com.environment.environmentDataAnalysis.ServiceInterface.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;

    //Add all the methods
}
