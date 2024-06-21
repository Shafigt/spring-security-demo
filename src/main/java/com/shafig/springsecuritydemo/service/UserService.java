package com.shafig.springsecuritydemo.service;

import com.shafig.springsecuritydemo.model.dto.AuthRequest;
import com.shafig.springsecuritydemo.model.dto.AuthenticationResponse;
import com.shafig.springsecuritydemo.model.dto.UserDto;

public interface UserService {
    Long save(UserDto user);
    AuthenticationResponse authenticate(AuthRequest request);
}
