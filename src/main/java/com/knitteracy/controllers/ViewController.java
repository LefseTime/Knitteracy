/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knitteracy.controllers;

import com.knitteracy.entities.Chart;
import com.knitteracy.entities.User;
import com.knitteracy.service.Charts;
import com.knitteracy.service.DuplicateUsername;
import com.knitteracy.service.Users;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author sonia
 */
@Controller
public class ViewController {
    
    private final Users users;
    private final Charts charts;

    @Autowired
    public ViewController(Users users, Charts charts) {
        this.users = users;
        this.charts = charts;
    }

    @GetMapping("/")
    public String viewHome(Principal principal, Model model) {
        User user = new User();
        
        if (principal == null){
            user.setUsername(null);
        } else {
            user = users.getUser(principal.getName());
        }
        model.addAttribute("user", user);
        return "home";
    }

    @GetMapping("/login")
    public String viewLogin() {
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @GetMapping("/signup")
    public String viewSignup(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }
    
    @PostMapping("/signup")
    public String signup(String username, String password){
        try {
            users.addUser(username, password);
            return "redirect:/";
        } catch (EmptyResultDataAccessException | DuplicateUsername e) {
            return "redirect:/signup-error";
        }
    }

    @GetMapping("/signup-error")
    public String signupError(Model model) {
        model.addAttribute("signupError", true);
        return "signup";
    }

    @GetMapping("/user")
    public String viewUser(Principal principal, Model model) {
        if (principal == null){
            return "login";
        } else {
            User user = users.getUser(principal.getName());
            model.addAttribute("user", user);
            return "user";
        }   
    }

}
