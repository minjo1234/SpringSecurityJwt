package com.example.spring_security_jwt.service;

import com.example.spring_security_jwt.dto.CustomUserDetails;
import com.example.spring_security_jwt.entity.UserEntity;
import com.example.spring_security_jwt.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userdata = userRepository.findByUsername(username);

        if (userdata != null){
            return new CustomUserDetails(userdata);
        }
        return null;
    }
}
