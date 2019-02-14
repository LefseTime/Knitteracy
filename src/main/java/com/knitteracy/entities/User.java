/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knitteracy.entities;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author sonia
 */
public class User {
    
    private int userId;
    private String username;
    private String password;
    private List<Word> savedCharts;

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Word> getSavedCharts() {
        return savedCharts;
    }

    public void setSavedCharts(List<Word> savedCharts) {
        this.savedCharts = savedCharts;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.userId;
        hash = 89 * hash + Objects.hashCode(this.username);
        hash = 89 * hash + Objects.hashCode(this.password);
        hash = 89 * hash + Objects.hashCode(this.savedCharts);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.userId != other.userId) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.savedCharts, other.savedCharts)) {
            return false;
        }
        return true;
    }
    
    
    
}
