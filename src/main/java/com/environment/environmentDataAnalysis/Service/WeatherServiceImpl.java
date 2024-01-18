package com.environment.environmentDataAnalysis.Service;

import com.environment.environmentDataAnalysis.DTO.WaterQualityDTO;
import com.environment.environmentDataAnalysis.DTO.WeatherDTO;
import com.environment.environmentDataAnalysis.Entity.Weather;
import com.environment.environmentDataAnalysis.Repository.WeatherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class WeatherServiceImpl {

    private final WeatherRepository weatherRepository;

    
    public WeatherDTO convertToDTO2(Weather weather)
    {
        return new WeatherDTO(
                weather.getLocation(),
                weather.getDateTime(),
                weather.getTemperature(),
                weather.getHumidity(),
                weather.getWindSpeed(),
                weather.getRainFall()
        );

    }
}
