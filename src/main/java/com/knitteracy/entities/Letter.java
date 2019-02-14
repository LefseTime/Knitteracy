/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knitteracy.entities;

/**
 *
 * @author sonia
 */
public class Letter {
    
    private int width;
    private char character;
    private boolean[][] coordinates;

    public Letter() {
        
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public boolean[][] getCoordinates() {
        return coordinates;
    }
    
    public void setCoordinates() {
        this.coordinates = coordinates;
    }
    
    
}
