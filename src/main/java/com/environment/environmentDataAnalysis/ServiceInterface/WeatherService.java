package com.environment.environmentDataAnalysis.ServiceInterface;

import com.environment.environmentDataAnalysis.DTO.WeatherDTO;
import com.environment.environmentDataAnalysis.Entity.Weather;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WeatherService {

    public WeatherDTO getByWeatherId(Long id);
    public ResponseEntity<List<WeatherDTO>> getAllWeatherRecords();
    public WeatherDTO addWeatherRecord(WeatherDTO weatherDTO);
    public Weather convertToEntity2(WeatherDTO weatherDTO);
    public WeatherDTO convertToDTO2(Weather weather);
}
