package com.environment.environmentDataAnalysis.Repository;

import com.environment.environmentDataAnalysis.Entity.ApplicationUser;

public interface UserRepository {
    void save(ApplicationUser admin);
}
