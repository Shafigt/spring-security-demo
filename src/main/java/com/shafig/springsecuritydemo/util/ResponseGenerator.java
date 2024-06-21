package com.shafig.springsecuritydemo.util;

import com.shafig.springsecuritydemo.model.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseGenerator {

    public static <T> ResponseEntity<ResponseDto<T>> generateResponse(T data) {
        return ResponseEntity.ok(new ResponseDto<T>(data, HttpStatus.OK.name()));
    }
}
