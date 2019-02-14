///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.knitteracy.data;
//
//import com.knitteracy.entities.Letter;
//import org.junit.After;
//import org.junit.AfterClass;
//import static org.junit.Assert.assertEquals;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
///**
// *
// * @author sonia
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class LetterDaoDBTest {
//
//    @Autowired
//    LetterDao letterDao;
//
//    public LetterDaoDBTest() {
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
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of getLetter method, of class LetterDaoDB.
//     */
//    @Test
//    public void testGetLetter() {
//
//        Letter letter = letterDao.getLetter(1, 'A');
//        assertEquals(4, letter.getWidth());
//    }
//
//}
