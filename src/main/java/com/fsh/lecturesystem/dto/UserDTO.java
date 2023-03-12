package com.fsh.lecturesystem.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {
    private Long userId;
    private String firstName;
    private String lastName;
    private String address;
    private String email;

    public UserDTO(String firstName, String lastName, String address, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(userId, userDTO.userId) && Objects.equals(firstName, userDTO.firstName) && Objects.equals(lastName, userDTO.lastName) && Objects.equals(address, userDTO.address) && Objects.equals(email, userDTO.email);
    }
}
