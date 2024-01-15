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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AirQualityServiceImpl implements AirQualityService {
    private final AirQualityRepository airQualityRepository;

    //get all the air quality records and using the stream api to map all the records
    // and return them as a list
    public ResponseEntity<List<AirQualityDTO>> getAllAirQualityRecords(){
        return new ResponseEntity<>(airQualityRepository.findAll().stream()
                .map(this::converttoDTO)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    //getting our air quality record by id
    @Override
    public AirQualityDTO getAirQualityById(Long id) {
        AirQuality airQuality = airQualityRepository.findById(id).
                orElseThrow(()->new RuntimeException("The requested air quality is not found"));
        return converttoDTO(airQuality);

    }

    //Adding a new air quality record
    public AirQualityDTO addAirQualityRecord(AirQualityDTO airQualityDTO)
    {
        AirQuality airQuality = convertToEntity(airQualityDTO);
        AirQuality appendedAirQuality = airQualityRepository.save(airQuality);
        return converttoDTO(appendedAirQuality);
    }
    /*
    Helper Methods
     */

    //Using a helper method to get the details from entity to the dto class and then displaying
    public AirQualityDTO converttoDTO(AirQuality airQuality)
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

    //Helper class for converting an DTO to an entity for updating the data while getting from the frontend
    public AirQuality convertToEntity(AirQualityDTO airQualityDTO)
    {
        AirQuality airQuality = new AirQuality();
        airQuality.setLocation(airQualityDTO.getLocation());
        airQuality.setDateTime(airQualityDTO.getDateTime());
        airQuality.setPm2_5(airQualityDTO.getPm2_5());
        airQuality.setPm10(airQualityDTO.getPm10());
        airQuality.setNo2(airQualityDTO.getNo2());
        airQuality.setO3(airQualityDTO.getO3());
        return airQuality;
    }



}
