package com.environment.environmentDataAnalysis.Service;

import com.environment.environmentDataAnalysis.DTO.AirQualityDTO;
import com.environment.environmentDataAnalysis.DataGenerator.AirQualityDataGenerator;
import com.environment.environmentDataAnalysis.Entity.AirQuality;
import com.environment.environmentDataAnalysis.Repository.AirQualityRepository;
import com.environment.environmentDataAnalysis.ServiceInterface.AirQualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AirQualityServiceImpl implements AirQualityService {

    @Autowired
    AirQualityRepository airQualityRepository;

    //find By Location
    public AirQualityDTO getAirQualityByLocation(String location){
        AirQuality airQuality = airQualityRepository.findByLocation(location).
                orElseThrow(() -> new RuntimeException("The requested air quality is not found"));
        return converttoDTO(airQuality);
    }

    //generate dummy data using the data generator class of DAta Generator package
    public List<AirQuality> generateAndSaveAirQualityData(Long numberOfRecords){
        List<AirQuality> generatedData = AirQualityDataGenerator.generateAirQualityData(numberOfRecords);
        return airQualityRepository.saveAll(generatedData);
    }

    //get all the air quality records and using the stream api to map all the records
    // and return them as a list
    public List<AirQualityDTO> getAllAirQualityRecords(){
        return airQualityRepository.findAll().stream()
                .map(this::converttoDTO)
                .collect(Collectors.toList());
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

    //update a record in air quality
    public AirQuality updateAirQualityUsingId(Long Id, AirQuality airQualityUpdated){

        AirQuality airQuality = airQualityRepository.findById(Id).
                orElseThrow(()->new RuntimeException("The requested air quality is not found"));
        airQuality.setLocation(airQualityUpdated.getLocation());
        airQuality.setPm2_5(airQualityUpdated.getPm2_5());
        airQuality.setPm10(airQualityUpdated.getPm10());
        airQuality.setNo2(airQualityUpdated.getNo2());
        airQuality.setO3(airQualityUpdated.getO3());
        return airQualityRepository.save(airQuality);
    }

    //delete a record in air quality

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
