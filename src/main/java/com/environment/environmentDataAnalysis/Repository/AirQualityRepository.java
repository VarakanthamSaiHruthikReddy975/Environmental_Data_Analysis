package com.environment.environmentDataAnalysis.Repository;


import com.environment.environmentDataAnalysis.Entity.AirQuality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirQualityRepository extends JpaRepository<AirQuality,Long> {
}
