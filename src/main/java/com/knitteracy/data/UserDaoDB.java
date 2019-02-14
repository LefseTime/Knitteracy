/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knitteracy.data;

import com.knitteracy.entities.Font;
import com.knitteracy.entities.User;
import com.knitteracy.entities.Word;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sonia
 */
@Repository
public class UserDaoDB implements UserDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    @Transactional
    public User addUser(String username, String password) {
        try {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);

            final String ADD_ONE = "INSERT INTO User (username, password) VALUES (?,?);";
            GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
            jdbc.update((Connection conn) -> {

                PreparedStatement statement = conn.prepareStatement(
                        ADD_ONE,
                        Statement.RETURN_GENERATED_KEYS);

                statement.setString(1, user.getUsername());
                statement.setString(2, user.getPassword());

                return statement;

            }, keyHolder);

            user.setUserId(keyHolder.getKey().intValue());

            return user;

        } catch (DataAccessException ex) {
            return null;
        }

    }

    @Override
    public User getUser(String username) {
        try {
            final String SELECT_ONE = "SELECT * FROM User WHERE username = ?;";
            User user = jdbc.queryForObject(SELECT_ONE, new UserMapper(), username);
            try {
                user.setSavedCharts(this.getSavedWordsByUser(username));
                return user;
            } catch (NullPointerException ex) {
                return user;
            }

        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {

        try {
            final String SELECT_ALL = "SELECT * FROM User;";

            List<User> users = jdbc.query(SELECT_ALL, new UserMapper());
            return users;
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public boolean saveChart(int kerning, int spacing, String text, int fontId, String username) {
        try {

            final String ADD_CHART = "INSERT INTO Chart (kerning, spacing, text, fontId, username) VALUES (?,?,?,?,?);";
            GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
            jdbc.update((Connection conn) -> {

                PreparedStatement statement = conn.prepareStatement(
                        ADD_CHART,
                        Statement.RETURN_GENERATED_KEYS
                );

                statement.setInt(1, kerning);
                statement.setInt(2, spacing);
                statement.setString(3, text);
                statement.setInt(4, fontId);
                statement.setString(5, username);

                return statement;

            }, keyHolder);
            return true;
        } catch (DataAccessException ex) {
            return false;
        }

    }
    
    @Override
    public boolean deleteChart(int chartId) {
        try {

            final String DELETE_CHART = "DELETE FROM Chart WHERE chartId = ?;";
            jdbc.update(DELETE_CHART, chartId);
            return true;
        } catch (DataAccessException ex) {
            return false;
        }

    }

    @Override
    public List<Word> getSavedWordsByUser(String username) {
        try {
            final String SELECT_ALL = "SELECT * FROM Chart "
                    + "JOIN Font ON Chart.fontId = Font.fontId "
                    + "WHERE username = ?;";
            List<Word> words = jdbc.query(SELECT_ALL, new WordMapper(), username);
            return words;
        } catch (DataAccessException ex) {
            return null;

        }
    }

    public static final class WordMapper implements RowMapper<Word> {

        @Override
        public Word mapRow(ResultSet rs, int index) throws SQLException {

            Font font = new Font();
            font.setFontId(rs.getInt("fontId"));
            font.setDescription(rs.getString("description"));
            font.setName(rs.getString("name"));
            font.setSourceName(rs.getString("sourceName"));
            font.setSourceUrl(rs.getString("sourceUrl"));
            font.setHeight(rs.getInt("height"));

            Word word = new Word();
            word.setChartId(rs.getInt("chartId"));
            word.setWordStr(rs.getString("text"));
            word.setKerning(rs.getInt("kerning"));
            word.setSpacing(rs.getInt("spacing"));
            word.setFont(font);

            return word;
        }
    }

    public static final class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int index) throws SQLException {

            User user = new User();

            user.setUserId(rs.getInt("userId"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));

            return user;
        }
    }

}
