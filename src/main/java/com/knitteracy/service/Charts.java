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
import com.knitteracy.entities.Word;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sonia
 */
@Service
public class Charts {

    @Autowired
    FontDao fontDao;

    @Autowired
    LetterDao letterDao;
    
    @Autowired
    UserDao userDao;

    public Font getFont(int fontId) {
        return fontDao.getFont(fontId);
    }

    public List<Font> getAllFonts() {
        return fontDao.getAllFonts();
    }

    public Word getWord(String wordRequest, int fontId) {
        
        Word word = new Word();
        List<Letter> wordLetters = new ArrayList<>();
        for (int i = 0; i < wordRequest.length(); i++) {
            char letterChar = wordRequest.charAt(i);
            Letter letter = letterDao.getLetter(fontId, letterChar);
            wordLetters.add(letter);
        }
        word.setLetters(wordLetters);
        word.setFont(fontDao.getFont(fontId));
        word.setWordStr(wordRequest);

        return word;
    }
    
    public boolean saveChart(int kerning, int spacing, String text, int fontId, String username){
        try {
            userDao.saveChart(kerning, spacing, text, fontId, username);
            return true;
        } catch (Exception e){
            return false;
        }
    }
    
    public boolean deleteChart(int chartId){
        try {
            userDao.deleteChart(chartId);
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
