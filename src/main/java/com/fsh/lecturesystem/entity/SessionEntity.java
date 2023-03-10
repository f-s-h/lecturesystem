package com.fsh.lecturesystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="SESSION")
@NoArgsConstructor
@Getter
@Setter
public class SessionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "session_generator")
    @SequenceGenerator(name="session_generator", sequenceName = "session_seq", allocationSize = 1)
    private Long userId;
    private String session;

    public SessionEntity(String session){
        this.session = session;
    }
}
