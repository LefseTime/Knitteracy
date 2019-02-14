/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knitteracy.controllers;

import com.knitteracy.entities.Font;
import com.knitteracy.entities.Word;
import com.knitteracy.service.Charts;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sonia
 */
@RestController
public class ChartController {

    private final Charts charts;

    @Autowired
    public ChartController(Charts charts) {
        this.charts = charts;
    }

    @PostMapping("/api/word/{wordRequest}/{fontRequest}")
    public Word getWord(@PathVariable String wordRequest, @PathVariable int fontRequest) {
        return charts.getWord(wordRequest, fontRequest);
    }

    @PostMapping("/api/words/{wordRequest}")
    public List<Word> getWords(@PathVariable String wordRequest) {
        List<Font> allFonts = charts.getAllFonts();
        List<Word> words = new ArrayList<>();

        for (Font font : allFonts) {
            Word word = charts.getWord(wordRequest, font.getFontId());
            
            word.setFont(font);
            
            words.add(word);
        }

        return words;
    }
    
    @PostMapping("/api/saveChart")
    public ResponseEntity<String> saveChart(String kerningStr, String spacingStr, String text, String fontIdStr, String username){
        int kerning = Integer.parseInt(kerningStr);
        int spacing = Integer.parseInt(spacingStr);
        int fontId = Integer.parseInt(fontIdStr);
        
        if (username.equals("")){
            return new ResponseEntity<String>("Unauthorized User", HttpStatus.FORBIDDEN);
        } else {
            charts.saveChart(kerning, spacing, text, fontId, username);
            return new ResponseEntity<String>("Saved", HttpStatus.CREATED);
        }  
    } 
    
    @PostMapping("/api/deleteChart/{chartId}")
    public ResponseEntity<String> deleteChart(@PathVariable int chartId){
        charts.deleteChart(chartId);
        return new ResponseEntity<String>("Deleted", HttpStatus.OK);
        
    } 
}
