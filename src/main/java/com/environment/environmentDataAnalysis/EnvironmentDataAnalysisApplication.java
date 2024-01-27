package com.environment.environmentDataAnalysis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class EnvironmentDataAnalysisApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnvironmentDataAnalysisApplication.class, args);
	}

}
