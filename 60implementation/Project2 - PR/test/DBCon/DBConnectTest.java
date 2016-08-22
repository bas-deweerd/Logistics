package DBCon;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Bas
 */
public class DBConnectTest {
    DBConnect dbconnect = new DBConnect();
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
        dbconnect.closeDatabaseConnection();
    }
    
    @Test
    public void testExecuteFunctionAndSelectCount(){
        int beforeCount = dbconnect.selectCount("trailer");
        dbconnect.executeFunction("addnewtrailer(44-AA-BB, 500)");
        int afterCount = dbconnect.selectCount("trailer");
        
        int expected = beforeCount+1;
        int actual = afterCount;
        
        assertEquals("Execute function failed.", expected, actual);
        
        dbconnect.deleteQuery("trailer", "licenseplate", "44-AA-BB");
    }
    
    @Test
    public void testDeleteQueries(){
        int countBeforeAdding = dbconnect.selectCount("trailer");
        TrailerMapper trailerMapper = new TrailerMapper();
        trailerMapper.addNewTrailer("44-AA-BB", 100);
        trailerMapper.addNewTrailer("55-BB-AA", 100);
        int countAfterAdding = dbconnect.selectCount("trailer");
        int expected = countBeforeAdding+2;
        int actual = countAfterAdding;
        assertEquals("Count failed", expected, actual);
        
        dbconnect.deleteQuery("trailer", "licenseplate", "44-AA-BB");
        dbconnect.deleteQuery("trailer", "licenseplate", "55-BB-AA");
    }
    
    @Test
    public void testPrepareStatement(){
        dbconnect.prepareStatement(null);
        //TODO
    }
    
    @Test
    public void testSelectQueries(){
        dbconnect.selectIntQuery(null, null, null, null);
        //TODO
    }
    
    @Test
    public void testUpdateQueries(){
        dbconnect.updateQuery(null, null, null, null, null);
        //TODO
    }
    
    @Test
    public void testResultSetQuery(){
        dbconnect.selectResultSetQuery(null, null);
        //TODO
    }
}
