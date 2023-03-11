package com.fsh.lecturesystem.controller;

import com.fsh.lecturesystem.dto.CourseEnrolledUserDTO;
import com.fsh.lecturesystem.dto.GroupAssignedUserDTO;
import com.fsh.lecturesystem.dto.UserDTO;
import com.fsh.lecturesystem.entity.CourseEnrolledUserEntity;
import com.fsh.lecturesystem.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    CourseEnrolledUserController courseEnrolledUserController;
    @Autowired
    GroupAssignedUserController groupAssignedUserController;

    @PostMapping
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
        userDTO = userService.saveUser(userDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable ("userId") Long userId){
        UserDTO userDTO = userService.getUser(userId);
        HttpStatus responseStatus;
        if(userDTO == null){
            responseStatus = HttpStatus.NOT_FOUND;
        }
        else{
            responseStatus = HttpStatus.OK;
        }
        return new ResponseEntity<>(userDTO, responseStatus);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity deleteUser(@PathVariable ("userId") Long userId){
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> userDTOList = userService.getAllUsers();
        return new ResponseEntity<>(userDTOList, HttpStatus.OK);
    }
    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable ("userId") Long userId, @RequestBody UserDTO userDTO){
        userDTO = userService.updateUser(userId, userDTO);
        HttpStatus responseStatus;
        if(userDTO == null){
            responseStatus = HttpStatus.NOT_FOUND;
        }
        else{
            responseStatus = HttpStatus.OK;
        }
        return new ResponseEntity<>(userDTO, responseStatus);
    }

    @PostMapping("/{userId}/enroll-course/{courseId}")
    public ResponseEntity<CourseEnrolledUserDTO> enrollUserInCourse(@PathVariable ("userId") Long userId, @PathVariable ("courseId") Long courseId){
        return courseEnrolledUserController.saveCourseEnrolledUser(new CourseEnrolledUserDTO(userId, courseId));
    }

    /**
     * TODO:
     * Delete all courseEnrolledUsers by userId
     * Get all courseEnrolledUsers by userId
     */

    @PostMapping("/{userId}/assign-group/{groupId}")
    public ResponseEntity<GroupAssignedUserDTO> assignUserToGroup(@PathVariable ("userId") Long userId, @PathVariable ("groupId") Long groupId){
        return groupAssignedUserController.saveGroupAssignedUser(new GroupAssignedUserDTO(userId, groupId));
    }

    /**
     * TODO:
     * Delete all groupAssignedUsers by userId
     * Get all groupAssignedUsers by userId
     */
}
