package com.environment.environmentDataAnalysis.ServiceInterface;

import com.environment.environmentDataAnalysis.DTO.WaterQualityDTO;
import com.environment.environmentDataAnalysis.Entity.WaterQuality;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WaterQualityService {

    //These are actual methods
    public WaterQualityDTO addWaterQualityRecord(WaterQualityDTO waterQualityDTO);
    public WaterQualityDTO getByWaterId(Long id);
    public ResponseEntity<List<WaterQualityDTO>> getAllRecords();

    //These are helper methods
    public WaterQuality convertToEntity1(WaterQualityDTO waterQualityDTO);
    public WaterQualityDTO convertToDTO1(WaterQuality waterQuality);

    public List<WaterQuality> generateAndSaveWaterQualityData(Long numberOfRecords);
}
