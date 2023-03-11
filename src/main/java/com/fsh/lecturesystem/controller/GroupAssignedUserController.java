package com.fsh.lecturesystem.controller;

import com.fsh.lecturesystem.dto.GroupAssignedUserDTO;
import com.fsh.lecturesystem.service.GroupAssignedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/groupAssignedUser")
public class GroupAssignedUserController {

    @Autowired
    GroupAssignedUserService groupAssignedUserService;

    @PostMapping
    public ResponseEntity<GroupAssignedUserDTO> saveGroupAssignedUser(@RequestBody GroupAssignedUserDTO groupAssignedUserDTO){
        groupAssignedUserDTO = groupAssignedUserService.saveGroupAssignedUser(groupAssignedUserDTO);
        return new ResponseEntity<>(groupAssignedUserDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/{userId}/{groupId}")
    public ResponseEntity deleteGroupAssignedUser(@PathVariable ("userId") Long userId, @PathVariable ("groupId") Long groupId){
        groupAssignedUserService.deleteGroupAssignedUser(userId, groupId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<GroupAssignedUserDTO>> getAllGroupAssignedUsers(){
        List<GroupAssignedUserDTO> groupAssignedUserDTOList = groupAssignedUserService.getAllGroupAssignedUsers();
        return new ResponseEntity<>(groupAssignedUserDTOList, HttpStatus.OK);
    }
}
