/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBCon;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bas
 */
public class UserMapperTest {
    
    UserMapper userMapper = new UserMapper();
    
    public UserMapperTest() {
    }
       
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        userMapper.getConnection().closeDatabaseConnection();
    }

    /**
     * Test of createAccount method, of class UserMapper.
     */
    @Test
    public void testCreateAccount() {       
        int beforeUserCount = userMapper.getConnection().selectCount(userMapper.getTableName());
        userMapper.createAccount("username1", "password1", 1);
        int afterUserCount = userMapper.getConnection().selectCount(userMapper.getTableName());

        int expected = beforeUserCount+1;
        int actual = afterUserCount;
        assertEquals("Account has not been added", expected, actual);
        
        //Cleaning of database after test.
        int id = userMapper.getID("username1");
        userMapper.deleteAccount(id);
    }
    
    
    
    @Test
    public void testGetUserType(){
        userMapper.createAccount("username1", "password1", 1);
        int id1 = userMapper.getID("username1");
        
        int expected1 = 1;
        int actual1 = userMapper.getUserType(id1);
        assertEquals("Incorrect user type", expected1, actual1);
        
        userMapper.createAccount("username2", "password2", 5);
        int id2 = userMapper.getID("username2");
        
        int expected2 = 5;
        int actual2 = userMapper.getUserType(id2);
        assertEquals("Incorrect user type", expected2, actual2);
      
        //Cleaning of database after test.
        userMapper.deleteAccount(id1);
        userMapper.deleteAccount(id2);
    }
    
    @Test
    public void testGetID(){
        userMapper.createAccount("username1", "password1", 1);
        int previousID = userMapper.getID("username1");
        
        userMapper.createAccount("username2", "password2", 1);
        
        int expected = previousID+1;
        int actual = userMapper.getID("username2");
        assertEquals("Incorrect ID found", expected, actual);
        
        //Cleaning of database after test.
        userMapper.deleteAccount(previousID);
        userMapper.deleteAccount(actual);
    }
    
    @Test
    public void testGetUsername(){
        userMapper.createAccount("username1", "password1", 1);
        int id = userMapper.getID("username1");
        
        String expected = "username1";
        String actual = userMapper.getUsername(id);
        assertEquals("Incorrect username found", expected, actual);
        
        //Cleaning of database after test.
        userMapper.deleteAccount(id);
    }
    
    @Test
    public void testGetPassword(){
        userMapper.createAccount("username1", "password1", 1);
        int id = userMapper.getID("username1");
        
        String expected = "password1";
        String actual = userMapper.getPassword(id);
        assertEquals("Incorrect password found", expected, actual);
        
        //Cleaning of database after test.
        userMapper.deleteAccount(id);
    }
    
    @Test
    public void testSetUsername(){
        userMapper.createAccount("username3", "password1", 1);
        int id = userMapper.getID("username3");
        userMapper.setUsername("newUsername", id);
        
        String expected = "newUsername";
        String actual = userMapper.getUsername(id);
        assertEquals("Set username failed", expected, actual);
        
        //Cleaning of database after test.
        userMapper.deleteAccount(id);
    }
    
    @Test
    public void testSetPassword(){
        userMapper.createAccount("username1", "password1", 1);
        int id = userMapper.getID("username1");
        userMapper.setPassword("password3", id);
        
        String expected = "password3";
        String actual = userMapper.getPassword(id);
        assertEquals("Set password failed", expected, actual);
        
        //Cleaning of database after test.
        userMapper.deleteAccount(id);
    }
    
    @Test
    public void testSetUserType(){
        userMapper.createAccount("username1", "password1", 1);
        int id = userMapper.getID("username1");
        userMapper.setUserType(5, id);
        
        int expected = 5;
        int actual = userMapper.getUserType(id);
        assertEquals("Set user type failed", expected, actual);
        
        //Cleaning of database after test.
        userMapper.deleteAccount(id);
    }
    
    @Test
    public void testDeleteAccount(){
        userMapper.createAccount("username1", "password1", 1);
        int id = userMapper.getID("username1");
        userMapper.deleteAccount(id);
         
        String expected = null;
        String actual = userMapper.getUsername(id);
        assertEquals("Delete account failed", expected, actual);
        
        //Cleaning of database after test.
        userMapper.deleteAccount(id);
    }
    
    @Test
    public void testLogin(){
        userMapper.createAccount("username1", "password1", 1);
        int id = userMapper.getID("username1");
        
        boolean expected = true;
        boolean actual = userMapper.login("username1", "password1");
        assertEquals("Login failed", expected, actual);
        
        expected = false;
        actual = userMapper.login("wrongUsername", "password1");
        assertEquals("Login failed", expected, actual);
        
        expected = false;
        actual = userMapper.login("username1", "wrongPassword");
        assertEquals("Login failed", expected, actual); 
        
        //Cleaning of database after test.
        userMapper.deleteAccount(id);
    }    
}