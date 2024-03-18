package com.environment.environmentDataAnalysis.Mapper;

import com.environment.environmentDataAnalysis.DTO.AirQualityDTO;
import com.environment.environmentDataAnalysis.Entity.AirQuality;
import com.environment.environmentDataAnalysis.MapperInterface.AirQualityMapper;

public class AirQualityMapperImpl implements AirQualityMapper {

    public AirQualityDTO entityToDTO(AirQuality airQuality){
       return airQuality == null? null : AirQualityDTO.builder()
               .location(airQuality.getLocation())
               .dateTime(airQuality.getDateTime())
               .pm2_5(airQuality.getPm2_5())
               .pm10(airQuality.getPm10())
               .no2(airQuality.getNo2())
               .o3(airQuality.getO3())
               .build();
    }

    public AirQuality dtoToEntity(AirQualityDTO airQualityDTO){
        return airQualityDTO == null? null: AirQuality.builder()
                .location(airQualityDTO.getLocation())
                .dateTime(airQualityDTO.getDateTime())
                .pm2_5(airQualityDTO.getPm2_5())
                .pm10(airQualityDTO.getPm10())
                .no2(airQualityDTO.getNo2())
                .o3(airQualityDTO.getO3())
                .build();
    }
}
