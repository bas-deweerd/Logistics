/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DBCon.LocationMapper;
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
public class LocationBeanTest {
    LocationBean instance = new LocationBean();
    public LocationBeanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new LocationBean(123, "companyName", "adress", "city", "country");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getLm method, of class LocationBean.
     */
    @Test
    public void testGetLm() {
        assertNull(instance.getLm());
    }
    
        /**
     * Test of setLm method, of class LocationBean.
     */
    @Test
    public void testSetLm() {
        LocationMapper lm = new LocationMapper();
        instance.setLm(lm);
        assertNotNull(lm);
    }


    /**
     * Test of isSelected method, of class LocationBean.
     */
    @Test
    public void testIsSelected() {
        boolean expResult = false;
        boolean result = instance.isSelected();
        assertEquals("Something went wrong @testisSelected: ", expResult, result);
     
    }

    /**
     * Test of setSelected method, of class LocationBean.
     */
    @Test
    public void testSetSelected() {
        boolean selected = false;
        LocationBean instance = new LocationBean();
        instance.setSelected(selected);
        assertFalse(selected);
    }

    /**
     * Test of getId method, of class LocationBean.
     */
    @Test
    public void testGetId() {

        int expResult = 123;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class LocationBean.
     */
    @Test
    public void testSetId() {
        int id = 0;
        LocationBean instance = new LocationBean();
        instance.setId(2);
        int expResult = 2;
        assertEquals(expResult, instance.getId());
    }

    /**
     * Test of getCompanyName method, of class LocationBean.
     */
    @Test
    public void testGetCompanyName() {
        String expResult = "companyName";
        String result = instance.getCompanyName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCompanyName method, of class LocationBean.
     */
    @Test
    public void testSetCompanyName() {
        String companyName = "testName";
        instance.setCompanyName("testName");
        assertEquals(companyName, instance.getCompanyName());
    }

    /**
     * Test of getAdress method, of class LocationBean.
     */
    @Test
    public void testGetAdress() {

        String expResult = "adress";
        String result = instance.getAdress();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAdress method, of class LocationBean.
     */
    @Test
    public void testSetAdress() {
        String adress = "testAdress";
        instance.setAdress("testAdress");
        assertEquals(adress, instance.getAdress());
    }

    /**
     * Test of getCity method, of class LocationBean.
     */
    @Test
    public void testGetCity() {
        String expResult = "city";
        String result = instance.getCity();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCity method, of class LocationBean.
     */
    @Test
    public void testSetCity() {
        String city = "pedocity";
        instance.setCity("pedocity");
        assertEquals(city, instance.getCity());
    }

    /**
     * Test of getCountry method, of class LocationBean.
     */
    @Test
    public void testGetCountry() {
        String expResult = "country";
        String result = instance.getCountry();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCountry method, of class LocationBean.
     */
    @Test
    public void testSetCountry() {
        String country = "testCountry";
        instance.setCountry("testCountry");
        assertEquals(country, instance.getCountry());
    }

    /**
     * Test of addLocation method, of class LocationBean.
     */
    @Test
    public void testAddLocation() {
        String expResult = "newLocation";
        String result = instance.addLocation();
        assertEquals(expResult, result);
    }
    
}
