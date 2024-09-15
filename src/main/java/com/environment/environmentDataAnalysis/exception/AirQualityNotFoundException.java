package com.environment.environmentDataAnalysis.exception;

public class AirQualityNotFoundException extends RuntimeException{

    public AirQualityNotFoundException(String message){
        super("The AirQuality record you are looking for is not found");
    }
}
