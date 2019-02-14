/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knitteracy.service;

import com.knitteracy.data.FontDao;
import com.knitteracy.data.LetterDao;
import com.knitteracy.data.UserDao;
import com.knitteracy.entities.Font;
import com.knitteracy.entities.Letter;
import com.knitteracy.entities.User;
import com.knitteracy.entities.Word;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author sonia
 */
@Service
public class Users {

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    LetterDao letterDao;

    @Autowired
    FontDao fontDao;

    @Autowired
    UserDao userDao;

    public User getUser(String username) {
        User user = userDao.getUser(username);

        try {
            List<Word> savedWords = user.getSavedCharts();

            for (Word savedWord : savedWords) {
                String wordRequest = savedWord.getWordStr();
                Font savedFont = savedWord.getFont();
                int fontId = savedFont.getFontId();
                List<Letter> wordLetters = new ArrayList<>();

                for (int i = 0; i < wordRequest.length(); i++) {
                    char letterChar = wordRequest.charAt(i);
                    Letter letter = letterDao.getLetter(fontId, letterChar);
                    wordLetters.add(letter);
                }

                savedWord.setLetters(wordLetters);
            }

            user.setSavedCharts(savedWords);
            return user;
        } catch (NullPointerException e) {
            return user;
        }
    };
    
    public User addUser(String username, String password)
            throws DuplicateUsername {
        if (this.getUser(username) != null) {
            throw new DuplicateUsername("Username taken.");
        }

        String encodedPassword = encoder.encode(password);

        User user = userDao.addUser(username, encodedPassword);

        return user;
    }

}
