package com.fsh.lecturesystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SessionDTO {
    private Long userId;
    private String session;

    public SessionDTO(Long userId, String session) {
        this.userId = userId;
        this.session = session;

    }
}
