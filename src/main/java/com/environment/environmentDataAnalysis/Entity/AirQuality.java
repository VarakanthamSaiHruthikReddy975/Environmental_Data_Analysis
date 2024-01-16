package com.environment.environmentDataAnalysis.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "air_quality")
public class AirQuality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min = 2, max = 100)
    private String location;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    @Column(nullable = false)
    @Min(0)
    private Double pm2_5;

    @Column(nullable = false)
    @Min(0)
    private Double pm10;

    @Column(nullable = false)
    @Min(0)
    @Max(100)
    private Double no2;

    @Column(nullable = false)
    @Min(0)
    @Max(500)
    private Double o3;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setDateTime(LocalDateTime dateTime) {
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

    public AirQuality() {
    }

    public AirQuality(Long id, String location, LocalDateTime dateTime, Double pm2_5, Double pm10, Double no2, Double o3) {
        this.id = id;
        this.location = location;
        this.dateTime = dateTime;
        this.pm2_5 = pm2_5;
        this.pm10 = pm10;
        this.no2 = no2;
        this.o3 = o3;
    }
}
