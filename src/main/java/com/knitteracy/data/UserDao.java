/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knitteracy.data;

import com.knitteracy.entities.User;
import com.knitteracy.entities.Word;
import java.util.List;

/**
 *
 * @author sonia
 */
public interface UserDao {
    
    public User addUser(String username, String password);
    public User getUser(String username);
    public List<User> getAllUsers();
    public List<Word> getSavedWordsByUser(String username);
    public boolean saveChart(int kerning, int spacing, String text, int fontId, String username);
    public boolean deleteChart(int chartId);
}
