package com.fsh.lecturesystem.controller;

import com.fsh.lecturesystem.dto.LocationDTO;
import com.fsh.lecturesystem.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/location")
public class LocationController {

    @Autowired
    LocationService locationService;

    @PostMapping
    public ResponseEntity<LocationDTO> saveLocation(@RequestBody LocationDTO locationDTO){
        locationDTO = locationService.saveLocation(locationDTO);
        return new ResponseEntity<>(locationDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{locationId}")
    public ResponseEntity<LocationDTO> getLocation(@PathVariable ("locationId") Long locationId){
        LocationDTO locationDTO = locationService.getLocation(locationId);
        HttpStatus responseStatus;
        if(locationDTO == null){
            responseStatus = HttpStatus.NOT_FOUND;
        }
        else{
            responseStatus = HttpStatus.OK;
        }
        return new ResponseEntity<>(locationDTO, responseStatus);
    }

    @DeleteMapping("/{locationId}")
    public ResponseEntity deleteLocation(@PathVariable ("locationId") Long locationId){
        locationService.deleteLocation(locationId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<LocationDTO>> getAllLocations(){
        List<LocationDTO> locationDTOList = locationService.getAllLocations();
        return new ResponseEntity<>(locationDTOList, HttpStatus.OK);
    }
}
