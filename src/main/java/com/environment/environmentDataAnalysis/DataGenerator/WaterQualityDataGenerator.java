package com.environment.environmentDataAnalysis.DataGenerator;

import com.environment.environmentDataAnalysis.Entity.WaterQuality;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WaterQualityDataGenerator {
    private static final Random random = new Random();

    public static List<WaterQuality> generateWaterQualityData(Long numberOfRecords){
        List<WaterQuality> waterQualityList = new ArrayList<>();

        for(long i=0;i<numberOfRecords;i++){
            WaterQuality waterQualityRecord = WaterQuality.builder()
                    .location("Location "+(i+1))
                    .dateTime(LocalDateTime.now().minusDays(random.nextInt(30)))
                    .ph(4.0 + random.nextDouble() * 5)
                    .turbidity(random.nextDouble() * 100)
                    .dissolvedOxygen(random.nextDouble() * 20)
                    .Conductivity(random.nextDouble()*2000)
                    .temperature(random.nextDouble() * 35)
                    .build();
            waterQualityList.add(waterQualityRecord);
        }
        return waterQualityList;
    }
}
