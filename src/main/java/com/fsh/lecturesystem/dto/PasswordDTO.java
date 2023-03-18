package com.fsh.lecturesystem.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class PasswordDTO {

    private Long userId;
    private String passwordHash;

    public PasswordDTO(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PasswordDTO that = (PasswordDTO) o;
        return Objects.equals(userId, that.userId) && Objects.equals(passwordHash, that.passwordHash);
    }
}
