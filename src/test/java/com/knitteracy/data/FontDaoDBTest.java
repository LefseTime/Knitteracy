/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.knitteracy.data;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author sonia
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FontDaoDBTest {
    
    @Autowired
    FontDao fontDao;
    
    public FontDaoDBTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getFont method, of class FontDaoDB.
     */
    @Test
    public void testGetFont() {
        assertEquals(15,fontDao.getFont(2).getHeight());
    }

    /**
     * Test of getAllFonts method, of class FontDaoDB.
     */
    @Test
    public void testGetAllFonts() {
        assertEquals(2,fontDao.getAllFonts().size());
    }
    
}
