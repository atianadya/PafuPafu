/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pafupafu;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aurelia
 */
public class PafuDefaultTest {
    
    public PafuDefaultTest() {
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
     * Test of setName method, of class PafuDefault.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Sophie";
        PafuDefault instance = new PafuDefault();
        instance.setName(name);
    }

    /**
     * Test of setGender method, of class PafuDefault.
     */
    @Test
    public void testSetGender() {
        System.out.println("setGender");
        int gender = 1;
        PafuDefault instance = new PafuDefault();
        instance.setGender(gender);
    }

    /**
     * Test of getName method, of class PafuDefault.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        PafuDefault instance = new PafuDefault();
        String expResult = "Sophie";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGender method, of class PafuDefault.
     */
    @Test
    public void testGetGender() {
        System.out.println("getGender");
        PafuDefault instance = new PafuDefault();
        int expResult = 1;
        int result = instance.getGender();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getType method, of class PafuDefault.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        PafuDefault instance = new PafuDefault();
        int expResult = 0;
        int result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
