package com.environment.environmentDataAnalysis.Controller;

import com.environment.environmentDataAnalysis.DTO.WaterQualityDTO;
import com.environment.environmentDataAnalysis.Entity.WaterQuality;
import com.environment.environmentDataAnalysis.ServiceInterface.WaterQualityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class WaterQualityController {
    private final WaterQualityService waterQualityService;

    public ResponseEntity<List<WaterQualityDTO>> getAllWaterQualityRecords(){

        List<WaterQualityDTO> getAllRecords = (List<WaterQualityDTO>) waterQualityService.getAllRecords();
        return ResponseEntity.ok(getAllRecords);
    }

    public ResponseEntity<WaterQualityDTO> getWaterQualityById(Long Id){
        WaterQualityDTO waterQualityDTO = waterQualityService.getById(Id);
        return ResponseEntity.ok(waterQualityDTO);
    }

    public ResponseEntity<WaterQualityDTO> addWaterQualityRecord(@RequestBody WaterQualityDTO waterQualityDTO)
    {
        WaterQualityDTO waterQualityDTO1 = waterQualityService.addAirQualityRecord(waterQualityDTO);
        return ResponseEntity.ok(waterQualityDTO1);
    }

}
