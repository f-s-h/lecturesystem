package com.fsh.lecturesystem.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordDTO {

    private Long userId;
    private String passwordHash;

    public PasswordDTO(Long userId, String passwordHash) {
        this.userId = userId;
        this.passwordHash = passwordHash;
    }
}
