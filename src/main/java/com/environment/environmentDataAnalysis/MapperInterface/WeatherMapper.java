package com.environment.environmentDataAnalysis.MapperInterface;

import com.environment.environmentDataAnalysis.DTO.WeatherDTO;
import com.environment.environmentDataAnalysis.Entity.Weather;

public interface WeatherMapper {

    public WeatherDTO convertToDTO(Weather weather);
    public Weather convertToEntity(WeatherDTO weatherDTO);
}
