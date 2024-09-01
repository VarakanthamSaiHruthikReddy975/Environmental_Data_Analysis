package com.environment.environmentDataAnalysis.DataGenerator;

import com.environment.environmentDataAnalysis.Entity.Weather;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherDataGenerator {
    private static final Random random = new Random();


    public static List<Weather> generateWeatherData(Long numberOfRecords) {
        List<Weather> weatherList = new ArrayList<>();

        for (long i = 0; i < numberOfRecords; i++) {
            Weather weather = Weather
                    .builder()
                    .location("Location"+(i+1))
                    .dateTime(LocalDateTime.now().minusDays(random.nextInt(30)))
                    .temperature(random.nextDouble()*50)
                    .humidity(random.nextDouble()*50)
                    .windSpeed(random.nextDouble()*100)
                    .rainFall(random.nextDouble()*200)
                    .build();
            weatherList.add(weather);
        }
        return weatherList;
    }
}
