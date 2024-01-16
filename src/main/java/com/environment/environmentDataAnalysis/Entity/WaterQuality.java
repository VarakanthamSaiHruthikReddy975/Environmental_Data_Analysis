package com.environment.environmentDataAnalysis.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="water_quality")
@Data
public class WaterQuality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min = 2, max = 100)
    private String location;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    @Column(nullable = false)
    @Min(4)
    @Max(9)
    private Double ph;

    @Column(nullable = false)
    @Min(0)
    @Max(100)
    private Double turbidity;

    @Column(nullable = false)
    @Min(0)
    @Max(20)
    private Double dissolvedOxygen;

    @Column(nullable = false)
    @Min(0)
    @Max(2000)
    private Double Conductivity;

    @Column(nullable = false)
    @Min(0)
    @Max(35)
    private Double temperature;

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
        return Conductivity;
    }

    public void setConductivity(Double conductivity) {
        Conductivity = conductivity;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WaterQuality)) return false;
        WaterQuality that = (WaterQuality) o;
        return id.equals(that.id) && location.equals(that.location) && dateTime.equals(that.dateTime) && ph.equals(that.ph) && turbidity.equals(that.turbidity) && dissolvedOxygen.equals(that.dissolvedOxygen) && Conductivity.equals(that.Conductivity) && temperature.equals(that.temperature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, location, dateTime, ph, turbidity, dissolvedOxygen, Conductivity, temperature);
    }

    public WaterQuality() {
    }
}
