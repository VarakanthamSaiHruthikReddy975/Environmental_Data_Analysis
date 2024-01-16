package com.environment.environmentDataAnalysis.ServiceInterface;

import com.environment.environmentDataAnalysis.DTO.WaterQualityDTO;
import com.environment.environmentDataAnalysis.Entity.WaterQuality;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WaterQualityService {

    public WaterQualityDTO addAirQualityRecord(WaterQualityDTO waterQualityDTO);
    public WaterQualityDTO getById(Long id);
    public ResponseEntity<List<WaterQualityDTO>> getAllRecords();
    public WaterQuality convertToEntity1(WaterQualityDTO waterQualityDTO);
    public WaterQualityDTO convertToDTO1(WaterQuality waterQuality);
}
