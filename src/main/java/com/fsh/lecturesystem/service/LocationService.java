package com.fsh.lecturesystem.service;

import com.fsh.lecturesystem.dto.LocationDTO;

import java.util.List;

public interface LocationService {
    public LocationDTO saveLocation(LocationDTO locationDTO);
    public LocationDTO getLocation(Long id);
    public List<LocationDTO> getAllLocations();
    public void deleteLocation(Long id);
}
