package com.environment.environmentDataAnalysis.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "weather_data")
@Data
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull
    private String location;


    @Column(name = "date_time", nullable = false)
    @NotNull
    private LocalDateTime dateTime;

    @Column(nullable = false)
    @NotNull
    @Min(-50)
    @Max(50)
    private Double temperature;

    @Column(nullable = false)
    @NotNull
    @Min(0)
    @Max(100)
    private Double humidity;

    @Column(nullable = false)
    @NotNull
    @Min(0)
    @Max(150)
    private Double windSpeed;

    @Column(nullable = false)
    @NotNull
    @Min(0)
    @Max(500)
    private Double rainFall;

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

    public Double getRainFall() {
        return rainFall;
    }

    public void setRainFall(Double rainFall) {
        this.rainFall = rainFall;
    }

    public Weather(Long id, String location, LocalDateTime dateTime, Double temperature, Double humidity, Double windSpeed, Double rainFall) {
        this.id = id;
        this.location = location;
        this.dateTime = dateTime;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.rainFall = rainFall;
    }

    public Weather() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Weather)) return false;
        Weather weather = (Weather) o;
        return id.equals(weather.id) && location.equals(weather.location) && dateTime.equals(weather.dateTime) && temperature.equals(weather.temperature) && humidity.equals(weather.humidity) && windSpeed.equals(weather.windSpeed) && rainFall.equals(weather.rainFall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, location, dateTime, temperature, humidity, windSpeed, rainFall);
    }


}
