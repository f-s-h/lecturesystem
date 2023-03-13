package com.fsh.lecturesystem.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PasswordDTO {

    private Long userId;
    private String passwordHash;

    public PasswordDTO(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
