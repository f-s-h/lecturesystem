package com.fsh.lecturesystem.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long userId;
    private String firstName;
    private String lastName;
    private String address;
    private String email;

    public UserDTO(Long userId, String firstName, String lastName, String address, String email) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
    }
}
