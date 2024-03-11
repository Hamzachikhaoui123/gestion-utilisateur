package com.hamza.demo.auth;

import com.hamza.demo.config.JwtService;
import com.hamza.demo.user.Role;
import com.hamza.demo.user.User;
import com.hamza.demo.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
   private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword()
            )
    );
    var user= userRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken =jwtService.generateToken(user);

        return AuthenticationResponse.builder().token(jwtToken).build();

    }

    public AuthenticationResponse register(RegisterRequest request) {


        var user= User.builder().firstName(request.getFirstName()).lastName(request.getLastName()).email(request.getEmail()).password(passwordEncoder.encode(request.getPassword())).role(Role.USER).build();

userRepository.save(user);
var jwtToken =jwtService.generateToken(user);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
