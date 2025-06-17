package com.environment.environmentDataAnalysis.exception;

public class WeatherDataNotFoundException extends RuntimeException{

    public WeatherDataNotFoundException(String message) {
        super("The weather data record that you are looking for is not found");
    }
}
