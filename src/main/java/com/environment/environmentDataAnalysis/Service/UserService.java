package com.environment.environmentDataAnalysis.Service;

import com.environment.environmentDataAnalysis.Entity.ApplicationUser;
import com.environment.environmentDataAnalysis.Entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

public class UserService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("In the user details service");

        if(!username.equals("EthanHunt")) throw new UsernameNotFoundException("Not EthanHunt");

        Set<Role> roles = new HashSet<>();
        roles.add(new Role(1,"USER"));
        // TODO Auto-generated method stub
        return new ApplicationUser(1,"EthanHunt",passwordEncoder.encode("password"),roles);
    }
}
