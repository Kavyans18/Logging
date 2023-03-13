package com.pws.LogUser.controller;

import com.pws.LogUser.entity.User;
import com.pws.LogUser.service.UserServiceImp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserServiceImp service;

    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        LOGGER.info("Saving the data");
        service.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable int id) {
        LOGGER.info("Updating the data to the DB");
        service.updateUser(user, id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        LOGGER.info("Getting user information using ID");
        User us = service.getUserById(id);
        return new ResponseEntity<>(us, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        LOGGER.info("Getting all the user information available");
        List<User> us = service.getAll();
        return new ResponseEntity<>(us, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable int id) {
        LOGGER.info("Deleting the user information from DB");
        service.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/byEmail/{email}")
    public ResponseEntity<User>getUserByEmail(@PathVariable String email) {
        LOGGER.info("Getting user information using Email");
        User u = service.getUserByEmail(email);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @GetMapping("/byPhone/{phoneNumber}")
    public ResponseEntity<User> getUserByPhoneNumber(@PathVariable long phoneNumber) {
        LOGGER.info("Getting user information using Phone Number");
        User user = service.getUserByPhone(phoneNumber);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/byFirstName/{firstName}")
    public ResponseEntity<List<User>> getUserByFirstName(@PathVariable String firstName) {
        LOGGER.info("Getting user information using first name");
        List<User> user = service.getUserByFirstName(firstName);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/byLastName/{lastName}")
    public ResponseEntity<List<User>> getUserByLastName(@PathVariable String lastName) {
        LOGGER.info("Getting user information using last name");
        List<User> user = service.getUserByLastName(lastName);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping("byGender/{gender}")
    public ResponseEntity<List<User>> getUserByGender(@PathVariable String gender){
        LOGGER.info("Getting user information using gender");
        List<User> user = service.getUserByGender(gender);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}

