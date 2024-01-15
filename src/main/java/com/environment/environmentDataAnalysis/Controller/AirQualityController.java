package com.environment.environmentDataAnalysis.Controller;

import com.environment.environmentDataAnalysis.DTO.AirQualityDTO;
import com.environment.environmentDataAnalysis.Entity.AirQuality;
import com.environment.environmentDataAnalysis.ServiceInterface.AirQualityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/air-quality")
public class AirQualityController {
    private AirQualityService airQualityService;


    //getting all the air quality records
    @GetMapping("/allRecords")
    public ResponseEntity<List<AirQualityDTO>> getAllAirQualityRecords()
    {
        List<AirQualityDTO> getAllRecords = (List<AirQualityDTO>) airQualityService.getAllAirQualityRecords();
        return ResponseEntity.ok(getAllRecords);
    }





}
