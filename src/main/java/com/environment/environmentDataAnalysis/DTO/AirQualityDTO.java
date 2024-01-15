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
public class AirQualityDTO {

    @NotNull
    @Size(min = 2, max = 100)
    private String location;

    @NotNull
    private Data dateTime;

    //Represents the concentrate of particulate matter that is less than
    // or equal to 2.5 mm in diameter
    @NotNull
    @Min(0)
    private Double pm2_5;

    //Represents the concentrate of particulate matter that is less than
    // or equal to 10 mm in diameter
    @NotNull
    @Min(0)
    private Double pm10;


    //Nitrogen Dioxide concentration in air interms of µg/m3
    @NotNull
    @Min(0)
    @Max(100)
    private Double no2;

    //Ozone concentration in air interms of µg/m3
    @NotNull
    @Min(0)
    @Max(500)
    private Double o3;

    public AirQualityDTO(String location, Data dateTime, Double pm2_5, Double pm10, Double no2, Double o3) {
        this.location = location;
        this.dateTime = dateTime;
        this.pm2_5 = pm2_5;
        this.pm10 = pm10;
        this.no2 = no2;
        this.o3 = o3;
    }

    public AirQualityDTO() {
    }

    public AirQualityDTO(String location, LocalDateTime dateTime, Double pm2_5, Double pm10, Double no2, Double o3) {
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(Data dateTime) {
        this.dateTime = dateTime;
    }

    public Double getPm2_5() {
        return pm2_5;
    }

    public void setPm2_5(Double pm2_5) {
        this.pm2_5 = pm2_5;
    }

    public Double getPm10() {
        return pm10;
    }

    public void setPm10(Double pm10) {
        this.pm10 = pm10;
    }

    public Double getNo2() {
        return no2;
    }

    public void setNo2(Double no2) {
        this.no2 = no2;
    }

    public Double getO3() {
        return o3;
    }

    public void setO3(Double o3) {
        this.o3 = o3;
    }

}
