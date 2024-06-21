package com.shafig.springsecuritydemo.controller;

import com.shafig.springsecuritydemo.model.dto.AuthRequest;
import com.shafig.springsecuritydemo.model.dto.AuthenticationResponse;
import com.shafig.springsecuritydemo.model.dto.ResponseDto;
import com.shafig.springsecuritydemo.model.dto.UserDto;
import com.shafig.springsecuritydemo.service.UserService;
import com.shafig.springsecuritydemo.util.MapUtils;
import com.shafig.springsecuritydemo.util.ResponseGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.shafig.springsecuritydemo.constant.Constants.ID;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<ResponseDto<Map<String, Long>>> save(@RequestBody UserDto userDTO) {
        return ResponseGenerator.generateResponse(MapUtils.generatePair(ID, userService.save(userDTO)));

    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthRequest request
    ) {
        return ResponseEntity.ok(userService.authenticate(request));
    }
}
