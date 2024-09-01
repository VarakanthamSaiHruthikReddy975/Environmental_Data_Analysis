package com.environment.environmentDataAnalysis.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.environment.environmentDataAnalysis.DataGenerator.WaterQualityDataGenerator;
import com.environment.environmentDataAnalysis.Entity.WaterQuality;
import com.environment.environmentDataAnalysis.Repository.WaterQualityRepository;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@AllArgsConstructor
public class WaterQualityRepositoryTests {

    private final WaterQualityRepository waterQualityRepository;

    @Test
    public void WaterQualityRepository_SaveRecord_ReturnSavedWaterQualityRecord(){
        WaterQuality waterQuality = WaterQuality
                .builder()
                .location("WaterQualityTesterLocation")
                .dateTime(LocalDateTime.now())
                .ph(7.5)
                .turbidity(3.2)
                .dissolvedOxygen(8.0)
                .Conductivity(500.0)
                .temperature(12.5)
                .build();

        WaterQuality savedWaterQuality = waterQualityRepository.save(waterQuality);

        assertThat(savedWaterQuality).isNotNull();
        assertThat(savedWaterQuality.getId()).isNotNull();
        assertThat(savedWaterQuality.getLocation()).isEqualTo("River Thames");
        assertThat(savedWaterQuality.getDateTime()).isNotNull();
        assertThat(savedWaterQuality.getPh()).isEqualTo(7.5);
        assertThat(savedWaterQuality.getTurbidity()).isEqualTo(3.2);
        assertThat(savedWaterQuality.getDissolvedOxygen()).isEqualTo(8.0); // Asserting dissolved oxygen
        assertThat(savedWaterQuality.getConductivity()).isEqualTo(500.0); // Asserting conductivity
        assertThat(savedWaterQuality.getTemperature()).isEqualTo(12.5); // Asserting temperature
    }

    @Test
    public void WaterQualityRepository_FindAllRecords_ReturnAllRecords(){
        WaterQuality waterQuality1 = WaterQuality
                .builder()
                .location("WaterQualityTesterLocation")
                .dateTime(LocalDateTime.now())
                .ph(7.5)
                .turbidity(3.2)
                .dissolvedOxygen(8.0)
                .Conductivity(500.0)
                .temperature(12.5)
                .build();
        WaterQuality waterQuality2 = WaterQuality
                .builder()
                .location("WaterQualityTesterLocation2")
                .dateTime(LocalDateTime.now())
                .ph(7.0)
                .turbidity(3.9)
                .dissolvedOxygen(7.0)
                .Conductivity(440.0)
                .temperature(19.5)
                .build();
        waterQualityRepository.save(waterQuality1);
        waterQualityRepository.save(waterQuality2);

        List<WaterQuality> WaterQualityAllRecords = waterQualityRepository.findAll();

        Assertions.assertThat(WaterQualityAllRecords).isNotNull();
        Assertions.assertThat(WaterQualityAllRecords.size()).isEqualTo(2);
    }

    //findById

    @Test
    public void WaterQualityRepository_FindById_ReturnById(){
        WaterQuality waterQuality1 = WaterQuality
                .builder()
                .location("WaterQualityTesterLocation")
                .dateTime(LocalDateTime.now())
                .ph(6.5)
                .turbidity(4.2)
                .dissolvedOxygen(7.2)
                .Conductivity(446.8)
                .temperature(33.5)
                .build();

        waterQualityRepository.save(waterQuality1);
        WaterQuality WaterQualityRecordById = waterQualityRepository.findById(waterQuality1.getId()).get();

        Assertions.assertThat(WaterQualityRecordById).isNotNull();

    }

    @Test
    public void whenGeneratedWaterQualityData_thenCorrectNumberOfRecordsGenerated(){
        Long numberOfRecords = 10L;
        List<WaterQuality> generatedWaterQualityData = WaterQualityDataGenerator.generateWaterQualityData(numberOfRecords);

        assertEquals(numberOfRecords.intValue(), generatedWaterQualityData.size());
    }

    @Test
    public void whenGenerateWaterQualityData_thenFieldsAreWithinExpectedRanges(){
        Long numberOfRecords = 5L;
        List<WaterQuality> generatedWaterQualityData = WaterQualityDataGenerator.generateWaterQualityData(numberOfRecords);

        for(WaterQuality record: generatedWaterQualityData){
            assertNotNull(record.getLocation());
            assertNotNull(record.getDateTime());
            assertTrue(record.getPh()>=4 && record.getPh()<=9);
            assertTrue(record.getTurbidity()>=0 && record.getTurbidity()<=100);
            assertTrue(record.getDissolvedOxygen()>=0 && record.getDissolvedOxygen()<=20);
            assertTrue(record.getConductivity()>=0 && record.getConductivity()<=100);
            assertTrue(record.getTemperature()>=0 && record.getTemperature()<=35);
        }
    }
}
