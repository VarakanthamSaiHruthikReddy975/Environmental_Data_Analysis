package com.environment.environmentDataAnalysis.Repository;

import com.environment.environmentDataAnalysis.Entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {
}
