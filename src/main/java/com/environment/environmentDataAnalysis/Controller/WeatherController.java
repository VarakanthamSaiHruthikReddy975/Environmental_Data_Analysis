package com.environment.environmentDataAnalysis.Controller;

import com.environment.environmentDataAnalysis.DTO.WeatherDTO;
import com.environment.environmentDataAnalysis.ServiceInterface.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/weather")
public class WeatherController {
    private final WeatherService weatherService;

    //Add all the methods

    @GetMapping("/allRecords")
    public ResponseEntity<List<WeatherDTO>> getAllWeatherRecords(){
        List<WeatherDTO> getAllWeatherRecords = (List<WeatherDTO>) weatherService.getAllWeatherRecords();
        return ResponseEntity.ok(getAllWeatherRecords);
    }

    @GetMapping("/{id}")

    public ResponseEntity<WeatherDTO> getWeatherById(@PathVariable Long Id){
        WeatherDTO weatherDTO = weatherService.getByWeatherId(Id);
        return ResponseEntity.ok(weatherDTO);
    }

    @PostMapping("/addRecord")
    public ResponseEntity<WeatherDTO> addWeatherRecord(@RequestBody WeatherDTO weatherDTO){
        WeatherDTO weatherDTO1 = weatherService.addWeatherRecord(weatherDTO);
        return ResponseEntity.ok(weatherDTO1);
    }
}
