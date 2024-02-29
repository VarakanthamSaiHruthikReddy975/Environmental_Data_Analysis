package com.environment.environmentDataAnalysis.Service;

import com.environment.environmentDataAnalysis.Repository.UserRepository;
import com.environment.environmentDataAnalysis.ServiceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("In the user details service");

        return (UserDetails) userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("user is not valid"));
    }

}
