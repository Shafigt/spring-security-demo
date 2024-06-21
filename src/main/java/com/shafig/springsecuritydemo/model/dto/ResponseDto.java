package com.shafig.springsecuritydemo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ResponseDto<T> {
    String status;
    T data;

    public ResponseDto(T data, String status) {
        this.status = status;
        this.data = data;
    }

}

