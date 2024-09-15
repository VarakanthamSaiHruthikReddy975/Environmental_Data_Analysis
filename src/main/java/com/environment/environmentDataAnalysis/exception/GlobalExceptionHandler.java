package com.environment.environmentDataAnalysis.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //Need to add ErrorResponse wrapper around it
    @ExceptionHandler(AirQualityNotFoundException.class)
    public ResponseEntity<String> handleAirQualityRecordNotFoundException(AirQualityNotFoundException airQualityNotFoundException) {
        return new ResponseEntity<>(airQualityNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    //Need to add ErrorResponse wrapper around it
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentsException(IllegalArgumentException illegalArgumentException){
        return new ResponseEntity<>(illegalArgumentException.getMessage(), HttpStatus.NOT_FOUND);
    }
}
