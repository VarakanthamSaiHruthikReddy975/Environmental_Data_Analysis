package com.environment.environmentDataAnalysis.ServiceInterface;

import org.springframework.security.core.Authentication;

public interface TokenService {

    public String generateJwt(Authentication auth);
}
