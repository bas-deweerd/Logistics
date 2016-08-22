/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBCon;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bas
 */
public class CustomerMapperTest {
    CustomerMapper instance = new CustomerMapper();
    int id;

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        instance.addNewCustomer("Jan", "0635256688", "jan@email.com", 1);
        id = instance.getId("Jan", "0635256688", "jan@email.com");
    }
    
    @After
    public void tearDown() {
        instance.deleteCustomer(id);
    }

    /**
     * Test of getName method, of class CustomerMapper.
     */
    @Test
    public void testGetName() {
        String expected = "Jan";
        String actual = instance.getName(id);
        assertEquals("Get name failed.", expected, actual);
        instance.deleteCustomer(id);
    }

    /**
     * Test of getPhoneNumber method, of class CustomerMapper.
     */
    @Test
    public void testGetPhoneNumber() {
        String expected = "0635256688";
        String actual = instance.getPhoneNumber(id);
        assertEquals("Get phone failed", expected, actual);
    }

    /**
     * Test of getEmail method, of class CustomerMapper.
     */
    @Test
    public void testGetEmail() {
        String expected = "jan@email.com";
        String actual = instance.getEmail(id);
        assertEquals("Get email failed", expected, actual);
    }

    /**
     * Test of getLocationNumber method, of class CustomerMapper.
     */
    @Test
    public void testGetLocationNumber() {
        int expected = 1;
        int actual = instance.getLocationNumber(id);
        assertEquals("Get location number failed", expected, actual);
    }

    /**
     * Test of addNewCustomer method, of class CustomerMapper.
     */
    @Test
    public void testAddNewCustomer() {
        DBConnect connection = new DBConnect();
        int beforeCount = connection.selectCount("customer");
        instance.addNewCustomer("Henk", "04856832152", "henk@email.nl", 2);
        int id2 = instance.getId("Henk", "04856832152", "henk@email.nl");
        int afterAddingOne = connection.selectCount("customer");
        instance.addNewCustomer("Sjaak", "054415151", "sjaak@live.nl", 3);
        int id3 = instance.getId("Sjaak", "054415151", "sjaak@live.nl");
        int afterAddingTwo = connection.selectCount("customer");
        
        assertEquals("Add new customer failed", beforeCount+1, afterAddingOne);
        assertEquals("Adding two customers failed", beforeCount+2, afterAddingTwo);
        instance.deleteCustomer(id2);
        instance.deleteCustomer(id3);
    }
    
    @Test
    public void testDeleteCustomer(){
        instance.addNewCustomer("Henk", "04856832152", "henk@email.nl", 2);
        int id2 = instance.getId("Henk", "04856832152", "henk@email.nl");
        instance.deleteCustomer(id2);
        int expected = -1;
        int actual = instance.getId("Henk", "04856832152", "henk@email.nl");
        assertEquals("Delete customer failed", expected, actual);
    }

    /**
     * Test of getId method, of class CustomerMapper.
     */
    @Test
    public void testGetId() {
        instance.addNewCustomer("Henk", "04856832152", "henk@email.nl", 2);
        instance.getId("Henk", "04856832152", "henk@email.nl");
        int expected = id+1;
        int actual = instance.getId("Henk", "04856832152", "henk@email.nl");
        assertEquals("Get id test failed", expected, actual);
    }

    /**
     * Test of setName method, of class CustomerMapper.
     */
    @Test
    public void testSetName() {
        instance.setName(id, "newname");
        String expected = "newname";
        String actual = instance.getName(id);
        assertEquals("Test set name failed", expected, actual);
        instance.setName(id, "Jan");
    }

    /**
     * Test of setPhoneNumber method, of class CustomerMapper.
     */
    @Test
    public void testSetPhoneNumber() {
        instance.setPhoneNumber(id, "0123456");
        String expected = "0123456";
        String actual = instance.getPhoneNumber(id);
        assertEquals("Test set phone number failed", expected, actual);
        instance.setName(id, "0635256688");
    }

    /**
     * Test of setEmail method, of class CustomerMapper.
     */
    @Test
    public void testSetEmail() {
        instance.setEmail(id, "newmail@mail.com");
        String expected = "newmail@mail.com";
        String actual = instance.getEmail(id);
        assertEquals("Test get email failed", expected, actual);
        instance.setEmail(id, "jan@email.com");
    }

    /**
     * Test of setLocationNumber method, of class CustomerMapper.
     */
    @Test
    public void testSetLocationNumber() {
        instance.setLocationNumber(id, 5);
        int expected = 5;
        int actual = instance.getLocationNumber(id);
        assertEquals("Set location number failed", expected, actual);
        instance.setLocationNumber(id, 1);
    }
}