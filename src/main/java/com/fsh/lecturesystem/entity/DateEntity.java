package com.fsh.lecturesystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="DATES")
@NoArgsConstructor
@Getter
@Setter
public class DateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_generator")
    @SequenceGenerator(name = "course_generator", sequenceName = "course_seq", allocationSize = 1)
    private Long dateId;
    private Long locationId;
    private Date date;

    public DateEntity(Long locationId, Date date) {
        this.locationId = locationId;
        this.date = date;
    }
}
