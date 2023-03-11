package com.fsh.lecturesystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="LOCATION")
@NoArgsConstructor
@Getter
@Setter
public class LocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_generator")
    @SequenceGenerator(name = "location_generator", sequenceName = "location_seq", allocationSize = 1)
    private Long locationId;
    private String room;
    private String building;
    private String address;

    public LocationEntity(String room, String building, String address) {
        this.room = room;
        this.building = building;
        this.address = address;
    }
}
