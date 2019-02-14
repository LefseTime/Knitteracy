/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knitteracy.entities;

import java.util.List;

/**
 *
 * @author sonia
 */
public class Word {
    
    private int chartId;
    private String wordStr;
    private List<Letter> letters;
    private Font font;
    private int kerning;
    private int spacing;

    public int getChartId() {
        return chartId;
    }

    public void setChartId(int chartId) {
        this.chartId = chartId;
    }
    
    public String getWordStr() {
        return wordStr;
    }
    
    public void setWordStr(String wordStr){
        this.wordStr = wordStr;
    }

    public List<Letter> getLetters() {
        return letters;
    }

    public void setLetters(List<Letter> letters) {
        this.letters = letters;
    }
    
    public Font getFont(){
        return font;
    }
    
    public void setFont(Font font){
        this.font = font;
    }

    public int getKerning() {
        return kerning;
    }

    public void setKerning(int kerning) {
        this.kerning = kerning;
    }

    public int getSpacing() {
        return spacing;
    }

    public void setSpacing(int spacing) {
        this.spacing = spacing;
    }
    
    
    
}
