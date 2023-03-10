package com.fsh.lecturesystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationDTO {
    private Long locationId;
    private String room;
    private String building;
    private String address;

    public LocationDTO(Long locationId, String room, String building, String address) {
        this.locationId = locationId;
        this.room = room;
        this.building = building;
        this.address = address;
    }
}
