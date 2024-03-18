package com.environment.environmentDataAnalysis.MapperInterface;

import com.environment.environmentDataAnalysis.DTO.AirQualityDTO;
import com.environment.environmentDataAnalysis.Entity.AirQuality;

public interface AirQualityMapper{

    public AirQualityDTO entityToDTO(AirQuality airQuality);
    public AirQuality dtoToEntity(AirQualityDTO airQualityDTO);
}
