/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBCon;

import java.sql.PreparedStatement;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Bas
 */
public class LocationMapperTest {
    LocationMapper lm = new LocationMapper();
    int id;
   
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    lm.addNewLocation("CompanyName", "adress", "city", "country");
    id = lm.getLocationId("adress", "city");
    }
    
    
    
    
    
    @After
    public void tearDown() throws Exception {
        int ex = lm.getLocationId("adress", "city");
        lm.deleteLocation(ex);
    }
    
    
    
    @Test
    public void testGetLocationId(){
     LocationMapper lm = new LocationMapper();
     lm.addNewLocation("CompanyName", "adress", "city", "country");
     lm.addNewLocation("CompanyName2", "adress2", "city2", "country2");
     int id = lm.getLocationId("CompanyName","adress");
     int expected = id;
     int actual = lm.getLocationId("CompanyName2", "adress2");
     assertEquals(expected, actual);
        
     lm.deleteLocation(id);
     lm.deleteLocation(actual);
    }
    
    @Test
    public void testGetCompanyName(){
        LocationMapper lm = new LocationMapper();
        lm.addNewLocation("CompanyName", "adress", "city", "country");
        lm.addNewLocation("CompanyName2", "adress2", "city2", "country2");
        int id = lm.getLocationId("CompanyName", "adress");
        int expected = id;
        int actual = lm.getLocationId("CompanyName2", "adress2");
        lm.getCompanyName(id);
        assertEquals(expected,actual);
        
        lm.deleteLocation(id);
        lm.deleteLocation(actual);
        
        
    }
    
    @Test
    public void testGetAdress(){
        String expResult = "adress";
        assertEquals(expResult, lm.getAdress(id));
    }
    
    @Test
    public void testGetCity(){
        int result = lm.getLocationId("adress", "city");
        String expResult = "city";
        assertEquals(expResult, lm.getCity(result));
    }
    
    @Test
    public void testGetCountry(){
        
        String expResult = "country";
        assertEquals(expResult, lm.getCountry(id));
    }
    
    @Test
    public void testSetCompanyName(){
        String expResult = "WUHU";
        lm.setCompanyName("WUHU", id);
        assertEquals(expResult, lm.getCompanyName(id));
    
    }
    
    @Test
    public void testSetAdress(){
        lm.setAdress("newAdress", id);
        String expResult = "newAdress";
        String actual    = lm.getAdress(id);
        assertEquals(expResult, actual);
    }
    
        @Test
    public void testSetCity(){
       lm.addNewLocation("CompanyName", "adress", "city", "country");
       int actual = lm.getLocationId("adress", "city");
       lm.getCity(actual);
       lm.setCity("petersburgh", actual);
            assertEquals("petersburgh", lm.getCity(actual));
    }
    
     @Test
    public void setCountry(){
        int test = lm.getLocationId("adress", "city");
        lm.getCountry(test);
        
    }
  
    
    
    @Test
    public void testAddNewLocation(){
        lm.addNewLocation("CompanyName7", "adress7", "city7", "country7");
        int actual = lm.getLocationId("adress7", "city7");
        String company = lm.getCompanyName(actual);
        
        assertEquals("CompanyName7", company);
        lm.deleteLocation(actual);
    }

    /**
     * Test of setCountry method, of class LocationMapper.
     */
    @Test
    public void testSetCountry() {
        String expCountry = "hunolulu";
        lm.setCountry("hunolulu", id);
        String actual = lm.getCountry(id);
        
        assertEquals(expCountry, actual);
    }

    /**
     * Test of deleteLocation method, of class LocationMapper.
     */
    @Test
    public void testDeleteLocation() {
        lm.addNewLocation("CompanyName6", "adress6", "city6", "country6");
        int newId = lm.getLocationId("adress6", "city6");
        assertEquals(lm.getCompanyName(newId), "CompanyName6");
        lm.deleteLocation(newId);
        assertEquals(lm.getCompanyName(newId), null);
    }
    
    
}
