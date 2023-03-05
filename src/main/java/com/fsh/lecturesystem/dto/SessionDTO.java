package com.fsh.lecturesystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SessionDTO {
    private Long sessionId;
    private String session;

    public SessionDTO(Long sessionId, String session) {
        this.sessionId = sessionId;
        this.session = session;
    }


}
