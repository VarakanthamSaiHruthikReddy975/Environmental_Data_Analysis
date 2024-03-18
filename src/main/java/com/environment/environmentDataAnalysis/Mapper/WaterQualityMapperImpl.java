package com.environment.environmentDataAnalysis.Mapper;

import com.environment.environmentDataAnalysis.DTO.WaterQualityDTO;
import com.environment.environmentDataAnalysis.Entity.WaterQuality;

public class WaterQualityMapperImpl {

    public WaterQualityDTO entityToDTO(WaterQuality waterQuality){
        return waterQuality == null?null : WaterQualityDTO.builder()
                .location(waterQuality.getLocation())
                .dateTime(waterQuality.getDateTime())
                .ph(waterQuality.getPh())
                .turbidity(waterQuality.getTurbidity())
                .dissolvedOxygen(waterQuality.getDissolvedOxygen())
                .conductivity(waterQuality.getConductivity())
                .temperature(waterQuality.getTemperature())
                .build();
    }

    public WaterQuality convertToEntity1(WaterQualityDTO waterQualityDTO)
    {
        return waterQualityDTO == null?null : WaterQuality.builder()
                .location(waterQualityDTO.getLocation())
                .dateTime(waterQualityDTO.getDateTime())
                .ph(waterQualityDTO.getPh())
                .turbidity(waterQualityDTO.getTurbidity())
                .dissolvedOxygen(waterQualityDTO.getDissolvedOxygen())
                .Conductivity(waterQualityDTO.getConductivity())
                .temperature(waterQualityDTO.getTemperature())
                .build();
    }
}
