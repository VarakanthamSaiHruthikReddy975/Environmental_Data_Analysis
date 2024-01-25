package com.environment.environmentDataAnalysis.Service;

import com.environment.environmentDataAnalysis.DTO.WaterQualityDTO;
import com.environment.environmentDataAnalysis.DataGenerator.WaterQualityDataGenerator;
import com.environment.environmentDataAnalysis.Entity.WaterQuality;
import com.environment.environmentDataAnalysis.Repository.WaterQualityRepository;
import com.environment.environmentDataAnalysis.ServiceInterface.WaterQualityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WaterQualityServiceImpl implements WaterQualityService {

    private final WaterQualityRepository waterQualityRepository;

    public List<WaterQuality> generateAndSaveWaterQualityData(Long numberOfRecords){
        List<WaterQuality> generateWaterQualityData = WaterQualityDataGenerator.generateWaterQualityData(numberOfRecords);
        return waterQualityRepository.saveAll(generateWaterQualityData);
    }

    //getting all the water quality records

    public ResponseEntity<List<WaterQualityDTO>> getAllRecords()
    {
        return new ResponseEntity<>(waterQualityRepository.findAll().stream().map(this::convertToDTO1).collect(Collectors.toList()), HttpStatus.OK);
    }
    //getting the water quality record by id
    public WaterQualityDTO getByWaterId(Long id){
        WaterQuality waterQuality = waterQualityRepository.findById(id).orElseThrow(()->new RuntimeException("Please enter the valid water id"));
        return convertToDTO1(waterQuality);
    }
    public WaterQualityDTO addWaterQualityRecord(WaterQualityDTO waterQualityDTO)
    {
        WaterQuality waterQuality = convertToEntity1(waterQualityDTO);
        WaterQuality appendedWaterQuality = waterQualityRepository.save(waterQuality);
        return convertToDTO1(appendedWaterQuality);
    }



    public WaterQuality convertToEntity1(WaterQualityDTO waterQualityDTO)
    {
        WaterQuality waterQuality = new WaterQuality();

        waterQuality.setLocation(waterQualityDTO.getLocation());
        waterQuality.setDateTime(waterQualityDTO.getDateTime());
        waterQuality.setPh(waterQualityDTO.getPh());
        waterQuality.setTurbidity(waterQualityDTO.getTurbidity());
        waterQuality.setDissolvedOxygen(waterQualityDTO.getDissolvedOxygen());
        waterQuality.setConductivity(waterQualityDTO.getConductivity());
        waterQuality.setTemperature(waterQualityDTO.getTemperature());
        return waterQuality;
    }

    @Override
    public WaterQualityDTO convertToDTO1(WaterQuality waterQuality) {
        return new WaterQualityDTO(
                waterQuality.getLocation(),
                waterQuality.getDateTime(),
                waterQuality.getPh(),
                waterQuality.getTurbidity(),
                waterQuality.getDissolvedOxygen(),
                waterQuality.getConductivity(),
                waterQuality.getTemperature());
    }


}
