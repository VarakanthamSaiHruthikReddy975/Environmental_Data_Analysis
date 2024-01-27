package com.environment.environmentDataAnalysis.Service;

import com.environment.environmentDataAnalysis.DTO.WeatherDTO;
import com.environment.environmentDataAnalysis.Entity.Weather;
import com.environment.environmentDataAnalysis.Repository.WeatherRepository;
import com.environment.environmentDataAnalysis.ServiceInterface.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository weatherRepository;
    public WeatherDTO getByWeatherId(Long id){
        Weather weather = weatherRepository.findById(id).orElseThrow(()->new RuntimeException("Please enter the valid weather id"));
        return convertToDTO2(weather);
    }

    public ResponseEntity<List<WeatherDTO>> getAllWeatherRecords(){
        return new ResponseEntity<>(weatherRepository.findAll()
                .stream().map(this::convertToDTO2).collect(Collectors.toList()), HttpStatus.OK);
    }
    public WeatherDTO addWeatherRecord(WeatherDTO weatherDTO){
        Weather weather = convertToEntity2(weatherDTO);
        Weather addWeatherRecord = weatherRepository.save(weather);
        return convertToDTO2(addWeatherRecord);
    }
    public Weather convertToEntity2(WeatherDTO weatherDTO){
        Weather weather = new Weather();

        weather.setLocation(weatherDTO.getLocation());
        weather.setDateTime(weatherDTO.getDateTime());
        weather.setTemperature(weatherDTO.getTemperature());
        weather.setHumidity(weatherDTO.getHumidity());
        weather.setWindSpeed(weatherDTO.getWindSpeed());
        weather.setRainFall(weatherDTO.getRainfall());
        return weather;
    }


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
