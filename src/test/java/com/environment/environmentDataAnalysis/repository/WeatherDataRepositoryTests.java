package com.environment.environmentDataAnalysis.repository;


import com.environment.environmentDataAnalysis.DataGenerator.WaterQualityDataGenerator;
import com.environment.environmentDataAnalysis.DataGenerator.WeatherDataGenerator;
import com.environment.environmentDataAnalysis.Entity.WaterQuality;
import com.environment.environmentDataAnalysis.Entity.Weather;
import com.environment.environmentDataAnalysis.Repository.WeatherRepository;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@AllArgsConstructor
public class WeatherDataRepositoryTests {

    private final WeatherRepository weatherRepository;


    @Test
    public void WeatherRepository_SaveRecord_ReturnSavedWeatherRecord(){
        Weather weather = Weather
                .builder()
                .location("WeatherTesterLocation")
                .dateTime(LocalDateTime.now())
                .temperature(32.843)
                .humidity(111.0)
                .windSpeed(78.843)
                .rainFall(832.83)
                .build();

        Weather savedWeatherRecord = weatherRepository.save(weather);

        assertThat(savedWeatherRecord).isNotNull();
        assertThat(savedWeatherRecord.getId()).isNotNull();
        assertThat(savedWeatherRecord.getLocation()).isEqualTo("Some Random Value");
        assertThat(savedWeatherRecord.getDateTime()).isNotNull();
        assertThat(savedWeatherRecord.getTemperature()).isEqualTo(32.843);
        assertThat(savedWeatherRecord.getWindSpeed()).isEqualTo(78.843);
        assertThat(savedWeatherRecord.getRainFall()).isEqualTo(832.83);
    }

    @Test
    public void WeatherRepository_FindAllRecords_ReturnAllRecords(){
        Weather weather = Weather
                .builder()
                .location("WeatherTesterLocation")
                .dateTime(LocalDateTime.now())
                .temperature(7.5)
                .windSpeed(3.2)
                .rainFall(8.0)
                .build();
        Weather weather2 = Weather
                .builder()
                .location("WaterQualityTesterLocation2")
                .dateTime(LocalDateTime.now())
                .temperature(7.5)
                .windSpeed(3.9)
                .rainFall(7.0)
                .build();
        weatherRepository.save(weather);
        weatherRepository.save(weather2);

        List<Weather> WeatherAllRecords = weatherRepository.findAll();

        Assertions.assertThat(WeatherAllRecords).isNotNull();
        Assertions.assertThat(WeatherAllRecords.size()).isEqualTo(2);
    }

    //findById

    @Test
    public void WeatherRepository_FindById_ReturnById(){
        Weather weather = Weather
                .builder()
                .location("WaterQualityTesterLocation")
                .dateTime(LocalDateTime.now())
                .temperature(6.5)
                .windSpeed(4.2)
                .rainFall(7.2)
                .build();

        weatherRepository.save(weather);
        Weather WeatherRecordById = weatherRepository.findById(weather.getId()).get();

        Assertions.assertThat(WeatherRecordById).isNotNull();
    }

    @Test
    public void whenGeneratedWeatherData_thenCorrectNumberOfRecordsGenerated(){
        Long numberOfRecords = 10L;
        List<Weather> generatedWeatherData = WeatherDataGenerator.generateWeatherData(numberOfRecords);

        assertEquals(numberOfRecords.intValue(), generatedWeatherData.size());
    }

    @Test
    public void whenGenerateWeatherData_thenFieldsAreWithinExpectedRanges(){
        Long numberOfRecords = 5L;
        List<Weather> generatedWeatherData = WeatherDataGenerator.generateWeatherData(numberOfRecords);

        for(Weather record: generatedWeatherData){
            assertNotNull(record.getLocation());
            assertNotNull(record.getDateTime());
            assertTrue(record.getTemperature()>=-50 && record.getTemperature()<=50);
            assertTrue(record.getHumidity()>=0 && record.getHumidity()<=100);
            assertTrue(record.getWindSpeed()>=0 && record.getWindSpeed()<=150);
            assertTrue(record.getRainFall()>=0 && record.getRainFall()<=500);
        }

    }
}



