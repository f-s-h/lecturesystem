package com.fsh.lecturesystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DateDTO {
    private Long dateId;
    private Long locationId;
    private Date date;

    public DateDTO(Long dateId, Long locationId, Date date) {
        this.dateId = dateId;
        this.locationId = locationId;
        this.date = date;
    }
}
