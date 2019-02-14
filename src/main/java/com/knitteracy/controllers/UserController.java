/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knitteracy.controllers;

import com.knitteracy.entities.User;
import com.knitteracy.service.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sonia
 */
@RestController
public class UserController {

    private final Users users;

    @Autowired
    public UserController(Users users) {
        this.users = users;
    }

    @PostMapping("/api/user/{username}")
    public User getUserInfo(@PathVariable String username) {
        User user = users.getUser(username);
        return user;
    }

//    @PostMapping("/api/signup")
//    public ResponseEntity<User> signupNewUser(@ModelAttribute(value="user") User user) {
//        try {
//            User newUser = users.addUser(user.getUsername(), user.getPassword());
//            return ResponseEntity.ok(newUser);
//        } catch (EmptyResultDataAccessException e) {
//            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
//        }
//
//    }

}
