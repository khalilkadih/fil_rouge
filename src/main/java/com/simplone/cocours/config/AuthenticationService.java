package com.youcode.youbooking.config;

import com.youcode.youbooking.Entity.Role;
import com.youcode.youbooking.Entity.Users;
import com.youcode.youbooking.Repository.UserRepository;
import lombok.var;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;



    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtils jwtUtils, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
    }

    public ResponseDTO register(RegisterDTO request) {
        Users user = Users.builder()
                .fname(request.getFirstName())
                .lname(request.getLastName())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.CLIENT)
                .email(request.getEmail())
                .build();
        userRepository.save(user);
        var jwtToken = jwtUtils.generateToken(user);
        return ResponseDTO.builder().token(jwtToken).build();
    }

    public ResponseDTO authenticate(ResponseDTO responseDTO) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(responseDTO.getEmail(), responseDTO.getPassword()));
        Users user = userRepository.findByEmail(responseDTO.getEmail()).get();
        String jwtToken = jwtUtils.generateToken(user);

        return ResponseDTO.builder().token(jwtToken).build();
    }
}
