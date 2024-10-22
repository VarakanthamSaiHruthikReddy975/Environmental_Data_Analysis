package com.environment.environmentDataAnalysis.exception;

public class WaterQualityNotFoundException extends RuntimeException{

    public WaterQualityNotFoundException(String message){
        super("The Water Quality record you are looking for is not found");
    }
}
