/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knitteracy.data;

import com.knitteracy.entities.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sonia
 */
@Repository
public class FontDaoDB implements FontDao{
    
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Font getFont(int fontId) {
        try {
            final String SELECT_ONE = "SELECT * FROM font WHERE fontId = ?;";
            return jdbc.queryForObject(SELECT_ONE, new FontMapper(), fontId);
        } catch (DataAccessException ex) {
            return null;
        }
    }
    
    @Override
    public List<Font> getAllFonts(){
        try {
            final String SELECT_ALL = "SELECT * FROM font;";
            return jdbc.query(SELECT_ALL, new FontDaoDB.FontMapper());
        } catch (DataAccessException ex) {
            throw ex;
        }
    };
    
    public static final class FontMapper implements RowMapper<Font> {

        @Override
        public Font mapRow(ResultSet rs, int index) throws SQLException {

            Font font = new Font();
            
            font.setFontId(rs.getInt("fontId"));;
            font.setName(rs.getString("name"));
            font.setHeight(rs.getInt("height"));
            font.setDescription(rs.getString("description"));
            font.setSourceName(rs.getString("sourceName"));
            font.setSourceUrl(rs.getString("sourceUrl"));

            return font;    
        }
    }
    
}
