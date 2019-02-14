/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knitteracy.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.knitteracy.entities.Letter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class LetterDaoDB implements LetterDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Letter getLetter(int fontId, char character) {
        try {
            final String SELECT_ONE = "SELECT * FROM letter WHERE fontId = ? AND `character` = ?;";
            return jdbc.queryForObject(SELECT_ONE, new LetterMapper(), fontId, Character.toString(character));
        } catch (DataAccessException ex) {
            return null;
        }
    }

    public static final class LetterMapper implements RowMapper<Letter> {

        @Override
        public Letter mapRow(ResultSet rs, int index) throws SQLException {

            String coordStr = rs.getString("coordinates");
            ObjectMapper objectMapper = new ObjectMapper();
            Reader reader = new StringReader(coordStr);
            try {
                Letter letter = objectMapper.readValue(reader, Letter.class);
                letter.setWidth(rs.getInt("width"));
                letter.setCharacter(rs.getString("character").charAt(0));

            return letter;
            } catch (IOException ex) {
                throw new SQLException("aaahhhhh");
            }      
        }
    }
}
