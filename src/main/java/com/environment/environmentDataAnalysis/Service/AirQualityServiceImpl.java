package com.environment.environmentDataAnalysis.Service;

import com.environment.environmentDataAnalysis.DTO.AirQualityDTO;
import com.environment.environmentDataAnalysis.Entity.AirQuality;
import com.environment.environmentDataAnalysis.Repository.AirQualityRepository;
import com.environment.environmentDataAnalysis.ServiceInterface.AirQualityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AirQualityServiceImpl implements AirQualityService {
    private AirQualityRepository airQualityRepository;

    //get all the air quality records and using the stream api to map all the records
    // and return them as a list
    public ResponseEntity<List<AirQualityDTO>> getAllAirQualityRecords(){
        return new ResponseEntity<>(airQualityRepository.findAll().stream()
                .map(this::converttoDTO)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    //Using a helper method to get the details from entity to the dto class and then displaying
    private AirQualityDTO converttoDTO(AirQuality airQuality)
    {
        return new AirQualityDTO(
                airQuality.getLocation(),
                airQuality.getDateTime(),
                airQuality.getPm2_5(),
                airQuality.getPm10(),
                airQuality.getNo2(),
                airQuality.getO3()
        );
    }

}
