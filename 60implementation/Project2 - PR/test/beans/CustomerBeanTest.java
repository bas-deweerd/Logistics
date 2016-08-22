/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author patrickrichter
 */
public class CustomerBeanTest {
    CustomerBean instance;
    
    public CustomerBeanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    instance = new CustomerBean("name","+491622382127","email@email.de",3445);    
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getName method, of class CustomerBean.
     */
    @Test
    public void testGetName() {
        String expResult = "name";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class CustomerBean.
     */
    @Test
    public void testSetName() {
        String expResult = "klaus";
        instance.setName("klaus");
        assertEquals(expResult, instance.getName());
    }

    /**
     * Test of getPhone_nr method, of class CustomerBean.
     */
    @Test
    public void testGetPhone_nr() {
        String expResult = "+491622382127";
        String result = instance.getPhone_nr();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPhone_nr method, of class CustomerBean.
     */
    @Test
    public void testSetPhone_nr() {
        String expResult = "12345";
        instance.setPhone_nr("12345");
        assertEquals(expResult, instance.getPhone_nr());
    }

    /**
     * Test of getEmail method, of class CustomerBean.
     */
    @Test
    public void testGetEmail() {
        String expResult = "email@email.de";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class CustomerBean.
     */
    @Test
    public void testSetEmail() {
        String expResult = "test@email.de";
        instance.setEmail("test@email.de");
        assertEquals(expResult, instance.getEmail());
    }

    /**
     * Test of getLocation_nr method, of class CustomerBean.
     */
    @Test
    public void testGetLocation_nr() {
        int expResult = 3445;
        int result = instance.getLocation_nr();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLocation_nr method, of class CustomerBean.
     */
    @Test
    public void testSetLocation_nr() {
        int expResult = 12345;
        instance.setLocation_nr(12345);
        assertEquals(expResult, instance.getLocation_nr());
    }
    
}
