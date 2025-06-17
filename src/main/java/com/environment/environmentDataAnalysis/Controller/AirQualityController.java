package com.environment.environmentDataAnalysis.Controller;

import com.environment.environmentDataAnalysis.DTO.AirQualityDTO;
import com.environment.environmentDataAnalysis.Entity.AirQuality;
import com.environment.environmentDataAnalysis.Repository.AirQualityRepository;
import com.environment.environmentDataAnalysis.ServiceInterface.AirQualityService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/air-quality")
//@CrossOrigin(origins = "http://localhost:4200/AirQuality")
public class AirQualityController {
    @Autowired
    AirQualityService airQualityService;

    //getting all the air quality records
    @GetMapping("/allRecords")
    public ResponseEntity<List<AirQualityDTO>> getAllAirQualityRecords()
    {
        List<AirQualityDTO> getAllRecords = airQualityService.getAllAirQualityRecords();
        if (getAllRecords == null || getAllRecords.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(getAllRecords);
    }

    //getting the air quality record by id
    @GetMapping("/id/{id}")
    public ResponseEntity<AirQualityDTO> getAirQualityById(@PathVariable Long id){
        AirQualityDTO airQualityDTO = airQualityService.getAirQualityById(id);
        return ResponseEntity.ok(airQualityDTO);
    }

    //find air quality by location
    @GetMapping("/location/{location}")
    public ResponseEntity<AirQualityDTO> getAirQualityByLocation(@PathVariable String location){
        AirQualityDTO airQualityDTO = airQualityService.getAirQualityByLocation(location);
        return ResponseEntity.ok(airQualityDTO);
    }

    //adding an record into the air quality table
    @PostMapping("/addRecord")
    public ResponseEntity<AirQualityDTO> addAirQualityRecord(@RequestBody AirQualityDTO airQualityDTO){
        AirQualityDTO addAQRecord = airQualityService.addAirQualityRecord(airQualityDTO);
        return ResponseEntity.ok(addAQRecord);
    }

    //adding generated dummy data
    @PostMapping("/generateDummyDataAQ/{numberOfRecords}")
    public ResponseEntity<List<AirQuality>> generateAirQualityData(@PathVariable Long numberOfRecords){
        List<AirQuality> generatedData = airQualityService.generateAndSaveAirQualityData(numberOfRecords);
        return ResponseEntity.ok(generatedData);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<AirQuality> updateAirQualityUsingId(@PathVariable Long Id, AirQuality airQualityUpdated){
        AirQuality airQuality = airQualityService.updateAirQualityUsingId(Id, airQualityUpdated);
        return ResponseEntity.ok(airQuality);
    }
}
