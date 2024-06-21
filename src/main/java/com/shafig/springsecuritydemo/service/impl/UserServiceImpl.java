package com.shafig.springsecuritydemo.service.impl;

import com.shafig.springsecuritydemo.model.dto.AuthRequest;
import com.shafig.springsecuritydemo.model.dto.AuthenticationResponse;
import com.shafig.springsecuritydemo.model.dto.UserDto;
import com.shafig.springsecuritydemo.model.entity.User;
import com.shafig.springsecuritydemo.repository.RoleRepository;
import com.shafig.springsecuritydemo.repository.UserRepository;
import com.shafig.springsecuritydemo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


    @Override
    public AuthenticationResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new BadCredentialsException("asf"));

        var jwtToken = jwtService.generateToken(user.getUsername());

        var refreshToken = jwtService.generateRefreshToken(request.getUsername());

        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    private void encryptPassword(UserDto user) {
        user.setPassword(encoder.encode(user.getPassword()));
    }

    @Override
    public Long save(UserDto user) {
        log.info("saving user: " + user);
        var role = roleRepository.findById(user.getRoleId()).orElse(null);
        encryptPassword(user);
        return userRepository.save(new User(user, role)).getId();
    }
}
