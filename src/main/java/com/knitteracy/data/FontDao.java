/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knitteracy.data;

import com.knitteracy.entities.Font;
import java.util.List;

/**
 *
 * @author sonia
 */

public interface FontDao {
    
    public Font getFont(int fontId);
    public List<Font> getAllFonts();
    
}
