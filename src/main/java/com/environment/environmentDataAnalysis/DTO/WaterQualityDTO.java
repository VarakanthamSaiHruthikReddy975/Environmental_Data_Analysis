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
}
