package com.example.multitenant.controller;

import com.example.multitenant.entity.User;
import com.example.multitenant.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/v1/api/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        try {
           log.trace("Call user service");
            userService.save(user);
            log.info("Save user");
            return new ResponseEntity<>(" User Saved",HttpStatus.OK);
        }
        catch (Exception e){
            
            log.error("Save user error");
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<?> getAllUser() throws SQLException {
        try {
            log.info("Get All User");
            return new ResponseEntity<>(userService.getAll(),HttpStatus.OK);
        }catch (Exception e){
            log.error("Failed get all user");
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}
