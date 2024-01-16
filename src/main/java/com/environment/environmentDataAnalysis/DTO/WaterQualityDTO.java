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
public class WaterQualityDTO {

    @NotNull
    @Size(min = 2, max = 100)
    private String location;

    @NotNull
    private LocalDateTime dateTime;

    //The ph values 7 indicate neutral, below 7 indicate acidic
    //Greater than 7 indicates basic i.e the solution is alkaline
    @Min(4)
    @Max(9)
    @NotNull
    private Double ph;


    @Min(0)
    @Max(100)
    private Double turbidity;

    @Min(0)
    @Max(20)
    private Double dissolvedOxygen;

    @Min(0)
    @Max(2000)
    private Double conductivity;

    @Min(0)
    @Max(35)
    private Double temperature;

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

    public Double getPh() {
        return ph;
    }

    public void setPh(Double ph) {
        this.ph = ph;
    }

    public Double getTurbidity() {
        return turbidity;
    }

    public void setTurbidity(Double turbidity) {
        this.turbidity = turbidity;
    }

    public Double getDissolvedOxygen() {
        return dissolvedOxygen;
    }

    public void setDissolvedOxygen(Double dissolvedOxygen) {
        this.dissolvedOxygen = dissolvedOxygen;
    }

    public Double getConductivity() {
        return conductivity;
    }

    public void setConductivity(Double conductivity) {
        this.conductivity = conductivity;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public WaterQualityDTO(String location, LocalDateTime dateTime, Double ph, Double turbidity, Double dissolvedOxygen, Double conductivity, Double temperature) {
        this.location = location;
        this.dateTime = dateTime;
        this.ph = ph;
        this.turbidity = turbidity;
        this.dissolvedOxygen = dissolvedOxygen;
        this.conductivity = conductivity;
        this.temperature = temperature;
    }

    public WaterQualityDTO() {
    }
}
