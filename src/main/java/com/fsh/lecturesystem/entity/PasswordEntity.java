package com.fsh.lecturesystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="PASSWORD")
@NoArgsConstructor
@Getter
@Setter
public class PasswordEntity {

    @Id
    private Long userId;

    @Column(nullable = false)
    private String passwordHash;

    public PasswordEntity(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
