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
public class TrailerMapperTest {
    TrailerMapper trailerMapper = new TrailerMapper();
    
    public TrailerMapperTest() {
    }
       
    @Before
    public void setUp() {
     
    }
    
    @After
    public void tearDown() {
        trailerMapper.getConnection().closeDatabaseConnection();
    }
    
    @Test
    public void testCreateTrailer(){
        int beforeTrailerCount = trailerMapper.getConnection().selectCount(trailerMapper.getTableName());
        trailerMapper.addNewTrailer("85-LI-88", 11);
        int afterTrailerCount = trailerMapper.getConnection().selectCount(trailerMapper.getTableName());

        int expected = beforeTrailerCount+1;
        int actual = afterTrailerCount;
        assertEquals("Trailer has not been added", expected, actual);
        
        //Cleaning of database after test.
        int trailerNumber = trailerMapper.getTrailerNumber("85-LI-88");
        trailerMapper.deleteTrailer(trailerNumber);
        
    }
    
    @Test
    public void testGetTrailerNumber(){
        trailerMapper.addNewTrailer("11-BB-11", 12);
        int previousTrailerNumber = trailerMapper.getTrailerNumber("11-BB-11");
        trailerMapper.addNewTrailer("99-AA-99", 15);
        
        int expected = previousTrailerNumber+1;
        int actual = trailerMapper.getTrailerNumber("99-AA-99");
        assertEquals("Get trailer number failed.", expected, actual);
        
        trailerMapper.deleteTrailer(previousTrailerNumber);
        trailerMapper.deleteTrailer(actual);
    }
    
    @Test
    public void testGetLoadingCapacity(){
        trailerMapper.addNewTrailer("11-CC-99", 16);
        int trailerNumber = trailerMapper.getTrailerNumber("11-CC-99");
        
        int expected = 16;
        int actual = trailerMapper.getLoadingCapacity(trailerNumber);
        assertEquals("Get loading capacity failed.", expected, actual);
        
        trailerMapper.deleteTrailer(trailerNumber);
    }
    
    @Test
    public void testGetLicensePlate(){
        trailerMapper.addNewTrailer("48-AA-48", 99);
        int trailerNumber = trailerMapper.getTrailerNumber("48-AA-48");
        
        String expected = "48-AA-48";
        String actual = trailerMapper.getLicensePlate(trailerNumber);
        assertEquals("Get license plate failed.", expected, actual);
        
        trailerMapper.deleteTrailer(trailerNumber);
    }
    
    @Test
    public void testSetLicensePlate(){
        trailerMapper.addNewTrailer("48-AA-48", 99);
        int trailerNumber = trailerMapper.getTrailerNumber("48-AA-48");
        trailerMapper.setLicensePlate("48-BB-48", trailerNumber);
        
        String expected = "48-BB-48";
        String actual = trailerMapper.getLicensePlate(trailerNumber);
        assertEquals("Set license plate failed.", expected, actual);
        
        trailerMapper.deleteTrailer(trailerNumber);
    }
    
    @Test
    public void testSetLoadingCapacity(){
        trailerMapper.addNewTrailer("11-CC-99", 16);
        int trailerNumber = trailerMapper.getTrailerNumber("11-CC-99");
        trailerMapper.setLoadingCapacity(88, trailerNumber);
        
        int expected = 88;
        int actual = trailerMapper.getLoadingCapacity(trailerNumber);
        assertEquals("Set loading capacity failed.", expected, actual);
        
        trailerMapper.deleteTrailer(trailerNumber);
    }
    
    @Test
    public void testDeleteTrailer(){
        int beforeTrailerCount = trailerMapper.getConnection().selectCount(trailerMapper.getTableName());
        trailerMapper.addNewTrailer("85-LI-88", 11);
        int afterTrailerCount = trailerMapper.getConnection().selectCount(trailerMapper.getTableName());

        int expected = beforeTrailerCount+1;
        int actual = afterTrailerCount;
        assertEquals("Trailer has not been added.", expected, actual);
        
        int trailerNumber = trailerMapper.getTrailerNumber("85-LI-88");
        trailerMapper.deleteTrailer(trailerNumber);
        
        afterTrailerCount = trailerMapper.getConnection().selectCount(trailerMapper.getTableName());
        expected = beforeTrailerCount;
        actual = afterTrailerCount;
        
        assertEquals("Trailer has not been removed.", expected, actual);
    }
}
