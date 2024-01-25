package com.environment.environmentDataAnalysis.DataGenerator;

import com.environment.environmentDataAnalysis.Entity.AirQuality;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AirQualityDataGenerator {

    private static final Random random = new Random();

    public static List<AirQuality> generateAirQualityData(Long numberOfRecords)
    {
        //This is one approach of adding the data by creating an object and then adding data through the setter methods
        //The other approach is using the builder which is done in WaterQualityGenerator class
        List<AirQuality> airQualityList = new ArrayList<>();
        for(long i=0;i<numberOfRecords;i++){
            AirQuality airQualityRecord = AirQuality.builder()
                    .location("Location "+(i+1))
                    .dateTime(LocalDateTime.now().minusDays(random.nextInt(30)))
                    .pm2_5(random.nextDouble()*100)
                    .pm10(random.nextDouble()*150)
                    .no2(random.nextDouble()*100)
                    .o3(random.nextDouble()*300)
                    .build();

            airQualityList.add(airQualityRecord);
        }
        return airQualityList;
    }
}
