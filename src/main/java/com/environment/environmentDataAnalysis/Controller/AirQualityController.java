package com.environment.environmentDataAnalysis.Controller;

import com.environment.environmentDataAnalysis.DTO.AirQualityDTO;
import com.environment.environmentDataAnalysis.Entity.AirQuality;
import com.environment.environmentDataAnalysis.ServiceInterface.AirQualityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/air-quality")
public class AirQualityController {
    private final AirQualityService airQualityService;


    //getting all the air quality records
    @GetMapping("/allRecords")
    public ResponseEntity<List<AirQualityDTO>> getAllAirQualityRecords()
    {
        List<AirQualityDTO> getAllRecords = (List<AirQualityDTO>) airQualityService.getAllAirQualityRecords();
        return ResponseEntity.ok(getAllRecords);
    }

    //getting the air quality record by id
    @GetMapping("/{id}")
    public ResponseEntity<AirQualityDTO> getAirQualityById(@PathVariable Long id){
        AirQualityDTO airQualityDTO = airQualityService.getAirQualityById(id);
        return ResponseEntity.ok(airQualityDTO);
    }

    //adding an record into the air quality table
    @PostMapping("/addRecord")
    public ResponseEntity<AirQualityDTO> addAirQualityRecord(@RequestBody AirQualityDTO airQualityDTO){
        AirQualityDTO addAQRecord = airQualityService.addAirQualityRecord(airQualityDTO);
        return ResponseEntity.ok(addAQRecord);
    }

}
