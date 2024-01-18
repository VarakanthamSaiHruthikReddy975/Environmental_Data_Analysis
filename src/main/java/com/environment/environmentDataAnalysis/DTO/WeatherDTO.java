package com.environment.environmentDataAnalysis.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class WeatherDTO {

    @NotNull
    @Size(min = 2, max = 100)
    private String location;

    @NotNull
    private LocalDateTime dateTime;

    @NotNull
    @Min(-50)
    @Max(50)
    private Double temperature;

    @NotNull
    @Min(0)
    @Max(100)
    private Double humidity;

    @NotNull
    @Min(0)
    @Max(150)
    private Double windSpeed;

    @NotNull
    @Min(0)
    @Max(500)
    private Double rainfall;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Double getRainfall() {
        return rainfall;
    }

    public void setRainfall(Double rainfall) {
        this.rainfall = rainfall;
    }

    public WeatherDTO() {
    }

    public WeatherDTO(String location, LocalDateTime dateTime, Double temperature, Double humidity, Double windSpeed, Double rainfall) {
        this.location = location;
        this.dateTime = dateTime;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.rainfall = rainfall;
    }
}
