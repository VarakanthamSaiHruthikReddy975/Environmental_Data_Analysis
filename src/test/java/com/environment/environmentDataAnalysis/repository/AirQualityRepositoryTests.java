package com.environment.environmentDataAnalysis.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.LIST;

import com.environment.environmentDataAnalysis.Entity.AirQuality;
import com.environment.environmentDataAnalysis.Repository.AirQualityRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@AllArgsConstructor
public class AirQualityRepositoryTests {
    private final AirQualityRepository airQualityRepository;

    @Test
    public void AirQualityRepository_SaveRecord_ReturnSavedAirQualityRecord(){

        //Arranging
        AirQuality airQuality = AirQuality
                .builder()
                .location("TesterLocation")
                .pm2_5(10.0)
                .pm10(20.0)
                .no2(30.0)
                .o3(40.0)
                .build();

        //Act
        AirQuality savedAirQualityRecord = airQualityRepository.save(airQuality);
        //Assert
        assertThat(savedAirQualityRecord).isNotNull();
        assertThat(savedAirQualityRecord.getLocation()).isEqualTo("TestLocation");
        assertThat(savedAirQualityRecord.getPm2_5()).isEqualTo(10.0);
        assertThat(savedAirQualityRecord.getPm10()).isEqualTo(20.0);
        assertThat(savedAirQualityRecord.getNo2()).isEqualTo(30.0);
        assertThat(savedAirQualityRecord.getO3()).isEqualTo(40.0);
    }

    @Test
    public void AirQualityRepository_FindAllRecords_ReturnAllRecords(){
        AirQuality airQuality1 = AirQuality
                .builder()
                .location("TesterLocation1")
                .pm2_5(18.0)
                .pm10(20.82)
                .no2(39.4)
                .o3(52.9)
                .build();

        AirQuality airQuality2 = AirQuality
                .builder()
                .location("TesterLocation2")
                .pm2_5(24.2)
                .pm10(38.82)
                .no2(31.4)
                .o3(59.9)
                .build();

        airQualityRepository.save(airQuality1);
        airQualityRepository.save(airQuality2);
        List<AirQuality> AirQualityAllRecords = airQualityRepository.findAll();

        Assertions.assertThat(AirQualityAllRecords).isNotNull();
        Assertions.assertThat(AirQualityAllRecords.size()).isEqualTo(2);
    }

    

}
