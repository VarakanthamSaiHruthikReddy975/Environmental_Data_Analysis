package com.environment.environmentDataAnalysis.Mapper;

import com.environment.environmentDataAnalysis.DTO.WeatherDTO;
import com.environment.environmentDataAnalysis.Entity.Weather;
import com.environment.environmentDataAnalysis.MapperInterface.WeatherMapper;

public class WeatherMapperImpl implements WeatherMapper {


    public WeatherDTO convertToDTO(Weather weather){
        return weather == null?null : WeatherDTO.builder()
                .location(weather.getLocation())
                .dateTime(weather.getDateTime())
                .temperature(weather.getTemperature())
                .humidity(weather.getHumidity())
                .windSpeed(weather.getWindSpeed())
                .rainfall(weather.getRainFall())
                .build();
    }

    public Weather convertToEntity(WeatherDTO weatherDTO){
        return weatherDTO== null?null : Weather.builder()
                .location(weatherDTO.getLocation())
                .dateTime(weatherDTO.getDateTime())
                .temperature(weatherDTO.getTemperature())
                .humidity(weatherDTO.getHumidity())
                .windSpeed(weatherDTO.getWindSpeed())
                .rainFall(weatherDTO.getRainfall())
                .build();
    }

}
