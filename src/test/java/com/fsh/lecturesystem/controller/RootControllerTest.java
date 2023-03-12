package com.fsh.lecturesystem.controller;

import com.fsh.lecturesystem.controller.RootController;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RootControllerTest {

    @Test
    public void helloWorld(@Autowired RootController rootController){
        ResponseEntity<String> response = rootController.helloWorld();
        assertEquals("Hello World from root!", response.getBody());
    }
}
