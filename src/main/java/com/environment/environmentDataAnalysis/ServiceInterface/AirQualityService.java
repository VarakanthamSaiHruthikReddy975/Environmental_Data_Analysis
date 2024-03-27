package com.environment.environmentDataAnalysis.ServiceInterface;

import com.environment.environmentDataAnalysis.DTO.AirQualityDTO;
import com.environment.environmentDataAnalysis.Entity.AirQuality;

import java.util.List;

public interface AirQualityService {
    //These are actual implementable methods
    public List<AirQualityDTO> getAllAirQualityRecords();

    public AirQualityDTO getAirQualityById(Long id);

    public AirQualityDTO addAirQualityRecord(AirQualityDTO airQualityDTO);

    /*
    These are helper methods
     */
    public AirQualityDTO converttoDTO(AirQuality airQuality);

    public AirQuality convertToEntity(AirQualityDTO airQualityDTO);

    public List<AirQuality> generateAndSaveAirQualityData(Long numberOfRecords);
    public AirQualityDTO getAirQualityByLocation(String location);

    public AirQuality updateAirQualityUsingId(Long Id, AirQuality airQualityUpdated);
}
