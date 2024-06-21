package com.shafig.springsecuritydemo.model.dto;


import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private Long id;

    private String photo;

    @Pattern(regexp = "^((?![0-9.])[a-zA-Z0-9.]{5,30}+(?<![_.]))$",message = "Username must be at least 5 characters long." +
            "Only alphanumeric characters and period is allowed.")
    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String confirmationPassword;

    private String phoneNumber;

    private String gender;

    private Long roleId;

    private boolean active = true;

    private String fullName;

}
