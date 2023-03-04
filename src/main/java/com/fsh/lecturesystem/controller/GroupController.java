package com.fsh.lecturesystem.controller;

import com.fsh.lecturesystem.dto.GroupDTO;
import com.fsh.lecturesystem.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/group")
public class GroupController {

    @Autowired
    GroupService groupService;

    @PostMapping
    public ResponseEntity<GroupDTO> saveGroup(@RequestBody GroupDTO groupDTO){
        groupDTO = groupService.saveGroup(groupDTO);
        return new ResponseEntity<>(groupDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GroupDTO>> getAllGroups(){
        List<GroupDTO> groupDTOList = groupService.getAllGroups();
        return new ResponseEntity<>(groupDTOList, HttpStatus.OK);
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<GroupDTO> getGroup(@PathVariable ("groupId") Long groupId){
        GroupDTO groupDTO = groupService.getGroup(groupId);
        HttpStatus httpStatus = HttpStatus.OK;
        if(groupDTO == null){
            httpStatus = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(groupDTO, httpStatus);
    }

    @DeleteMapping("/{groupId}")
    public ResponseEntity deleteGroup(@PathVariable ("groupId") Long groupId){
        groupService.deleteGroup(groupId);
        return ResponseEntity.noContent().build();
    }

}
