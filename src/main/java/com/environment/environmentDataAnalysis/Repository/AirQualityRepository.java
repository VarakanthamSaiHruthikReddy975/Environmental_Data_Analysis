package com.environment.environmentDataAnalysis.Repository;


import com.environment.environmentDataAnalysis.Entity.AirQuality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AirQualityRepository extends JpaRepository<AirQuality,Long> {
    Optional<AirQuality> findByLocation(String location);
}
