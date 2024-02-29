package com.environment.environmentDataAnalysis;

import com.environment.environmentDataAnalysis.Entity.ApplicationUser;
import com.environment.environmentDataAnalysis.Entity.Role;
import com.environment.environmentDataAnalysis.Repository.RoleRepository;
import com.environment.environmentDataAnalysis.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class EnvironmentDataAnalysisApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnvironmentDataAnalysisApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder){
		return args -> {
			if(roleRepository.findByAuthority("ADMIN").isPresent()){
				return;
			}
			Role adminRole = roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));
			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);

			ApplicationUser admin = new ApplicationUser(1,"admin", passwordEncoder.encode("password"),roles);
			userRepository.save(admin);
		};
	}
}
