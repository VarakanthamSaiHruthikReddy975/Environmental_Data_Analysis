package com.environment.environmentDataAnalysis.Repository;

import com.environment.environmentDataAnalysis.Entity.ApplicationUser;

import java.util.Optional;

public interface UserRepository {
    void save(ApplicationUser admin);

    Optional<Object> findByUsername(String username);
}
