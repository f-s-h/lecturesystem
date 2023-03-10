package com.fsh.lecturesystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="PASSWORDS")
@NoArgsConstructor
@Getter
@Setter
public class PasswordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "password_generator")
    @SequenceGenerator(name = "password_generator", sequenceName = "password_seq", allocationSize = 1)
    private Long userId;

    @Column(nullable = false)
    private String passwordHash;

    public PasswordEntity(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
