package com.environment.environmentDataAnalysis.Controller;

import com.environment.environmentDataAnalysis.DTO.WaterQualityDTO;
import com.environment.environmentDataAnalysis.Entity.WaterQuality;
import com.environment.environmentDataAnalysis.ServiceInterface.WaterQualityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/waterquality")
public class WaterQualityController {
    private final WaterQualityService waterQualityService;

    @GetMapping("/allRecords")
    public ResponseEntity<List<WaterQualityDTO>> getAllWaterQualityRecords(){
        List<WaterQualityDTO> getAllRecords = (List<WaterQualityDTO>) waterQualityService.getAllRecords();
        return ResponseEntity.ok(getAllRecords);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WaterQualityDTO> getWaterQualityById(@PathVariable Long Id){
        WaterQualityDTO waterQualityDTO = waterQualityService.getByWaterId(Id);
        return ResponseEntity.ok(waterQualityDTO);
    }

    @PostMapping("/addRecord")
    public ResponseEntity<WaterQualityDTO> addWaterQualityRecord(@RequestBody WaterQualityDTO waterQualityDTO)
    {
        WaterQualityDTO waterQualityDTO1 = waterQualityService.addWaterQualityRecord(waterQualityDTO);
        return ResponseEntity.ok(waterQualityDTO1);
    }

    @PostMapping("/generateDummyDataWQ/{numberOfRecords}")
    public ResponseEntity<List<WaterQuality>> generateWaterQualityData(@PathVariable Long numberOfRecords){
        List<WaterQuality> generatedData = waterQualityService.generateAndSaveWaterQualityData(numberOfRecords);
        return ResponseEntity.ok(generatedData);
    }

}
