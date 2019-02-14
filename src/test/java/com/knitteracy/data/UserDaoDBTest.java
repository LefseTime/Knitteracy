///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.knitteracy.data;
//
//import com.knitteracy.entities.User;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.test.context.junit4.SpringRunner;
//
///**
// *
// * @author sonia
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class UserDaoDBTest {
//    
//    @Autowired
//    private JdbcTemplate jdbc;
//    
//    @Autowired
//    UserDao userDao;
//    
//    public UserDaoDBTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//        final String SCORCHEDEARTH1 = "SET FOREIGN_KEY_CHECKS = 0";
//        final String SCORCHEDEARTH3 = "TRUNCATE TABLE User";
//        final String SCORCHEDEARTH4 = "SET FOREIGN_KEY_CHECKS = 0";
//        final String INSERTUSER = "insert into User (username, password) values (?,?)";
//        
//        jdbc.execute(SCORCHEDEARTH1);
//        jdbc.execute(SCORCHEDEARTH3);
//        jdbc.execute(SCORCHEDEARTH4);
//        jdbc.update(INSERTUSER, "testuser", "testpass");
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of getUser method, of class UserDaoDB.
//     */
//    @Test
//    public void testGetUser() {
//        //assertEquals("testuser",userDao.getUser(1).getUsername());
//        
//    }
//    
//    @Test
//    public void testAddUser(){
//        User user = new User();
//        user.setUsername("checking");
//        user.setPassword("thisisnothashed");
//        User fromDao = userDao.addUser(user.getUsername(),user.getPassword());
//        assertEquals("checking", fromDao.getUsername());
//    }
//    
//    @Test
//    public void testGetAllUsers(){
//        
//        assertEquals(1,userDao.getAllUsers().size());
//    }
//
//    /**
//     * Test of getSavedWordsByUser method, of class UserDaoDB.
//     */
//    @Test
//    public void testGetSavedWordsByUser() {
//        //method is called in getUser method
//        //assertEquals(2,userDao.getUser(1).getSavedCharts().size());
//    }
//    
//    @Test
//    public void testSaveChart() {
//        //method is called in getUser method
//        //assertEquals(2,userDao.getUser(1).getSavedCharts().size());
//    }
//    
//}
