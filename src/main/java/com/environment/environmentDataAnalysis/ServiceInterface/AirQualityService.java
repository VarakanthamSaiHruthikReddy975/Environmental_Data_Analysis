package com.environment.environmentDataAnalysis.ServiceInterface;

import com.environment.environmentDataAnalysis.DTO.AirQualityDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AirQualityService {
    public ResponseEntity<List<AirQualityDTO>> getAllAirQualityRecords();


}
