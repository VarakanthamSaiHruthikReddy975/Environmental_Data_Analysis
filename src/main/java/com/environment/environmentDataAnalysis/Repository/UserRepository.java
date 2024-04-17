package com.environment.environmentDataAnalysis.Repository;

import com.environment.environmentDataAnalysis.Entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<ApplicationUser, Integer> {

    Optional<Object> findByUsername(String username);
}
