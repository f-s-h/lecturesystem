package com.fsh.lecturesystem.controller;

import com.fsh.lecturesystem.dto.UserDTO;
import com.fsh.lecturesystem.service.UserService;
import org.apache.catalina.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserControllerTest {
    @Autowired
    UserController userController;
    @Autowired
    UserService userService;

    UserDTO user1 = new UserDTO("Fabian", "Heinrich", "address 1, munich, germany", "fabian.heinrich@tum.de");
    UserDTO user2 = new UserDTO("Spring", "", "imaginary-street 1, miami, united states of america", "imaginary@email.com");
    UserDTO user3 = new UserDTO("admin", "admin", "", "admin@admin.com");
    UserDTO user4 = new UserDTO("admin", "admin", "admin", "");
    List<UserDTO> userDTOList = new ArrayList<>();

    @BeforeAll
    public void init(){
        user1 = userController.saveUser(user1).getBody();
        user2 = userController.saveUser(user2).getBody();
        user3 = userController.saveUser(user3).getBody();
        user4 = userController.saveUser(user4).getBody();
        userDTOList.add(user1);
        userDTOList.add(user2);
        userDTOList.add(user3);
        userDTOList.add(user4);
    }

    @Test
    public void getUserDefault(){
        UserDTO shouldUserDTO = user1;
        HttpStatus shouldHttpStatus = HttpStatus.OK;
        ResponseEntity<UserDTO> observed = userController.getUser(user1.getUserId());
        assertEquals(shouldHttpStatus, observed.getStatusCode());
        assertEquals(shouldUserDTO, observed.getBody());
    }

    @Test
    public void getNonExistingUser(){
        Long invalidId = -1L;
        HttpStatus shouldHttpStatus = HttpStatus.NOT_FOUND;
        ResponseEntity<UserDTO> observed = userController.getUser(invalidId);
        assertEquals(shouldHttpStatus, observed.getStatusCode());
        assertEquals(null, observed.getBody());
    }




}
