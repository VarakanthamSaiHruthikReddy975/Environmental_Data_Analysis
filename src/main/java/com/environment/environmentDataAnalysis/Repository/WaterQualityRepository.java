package com.environment.environmentDataAnalysis.Repository;

import com.environment.environmentDataAnalysis.Entity.WaterQuality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterQualityRepository extends JpaRepository<WaterQuality, Long> {

}
