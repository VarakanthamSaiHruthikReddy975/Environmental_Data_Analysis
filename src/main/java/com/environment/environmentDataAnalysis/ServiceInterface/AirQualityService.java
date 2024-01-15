package com.environment.environmentDataAnalysis.ServiceInterface;

import com.environment.environmentDataAnalysis.DTO.AirQualityDTO;
import com.environment.environmentDataAnalysis.Entity.AirQuality;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AirQualityService {
    //These are actual implementable methods
    public ResponseEntity<List<AirQualityDTO>> getAllAirQualityRecords();

    public AirQualityDTO getAirQualityById(Long id);

    public AirQualityDTO addAirQualityRecord(AirQualityDTO airQualityDTO);

    /*
    These are helper methods
     */
    public AirQualityDTO converttoDTO(AirQuality airQuality);

    public AirQuality convertToEntity(AirQualityDTO airQualityDTO);
}
