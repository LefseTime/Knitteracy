/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knitteracy.security;

import com.knitteracy.data.UserDao;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author sonia
 */
@Service
public class UserService implements UserDetailsService {
    
    @Autowired
    UserDao userDao;

    //private static List<com.knitteracy.entities.User> users;

//    public UserService(UserDao userDao) {
//        this.userDao = userDao;
//        
//        users = userDao.getAllUsers();
//        
//        if (users == null) {
//            PasswordEncoder encoder = new BCryptPasswordEncoder();
//            users = new ArrayList<>();
//            
//            com.knitteracy.entities.User newUser = new com.knitteracy.entities.User();
//            newUser.setUsername("test");
//            newUser.setPassword(encoder.encode("test"));
//            
//            users.add(newUser);
//        }
//        
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        
        
        com.knitteracy.entities.User user = userDao.getUser(username);

        if (user == null) {
            throw new UsernameNotFoundException("Bummer.");
        }

        List<SimpleGrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("USER"));

        org.springframework.security.core.userdetails.User secUser = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);

        return secUser;
    }

}

