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
public class TruckMapperTest {

    TruckMapper truckMapper = new TruckMapper();
    private final String tableName = "truck"; //(s)

    @Before
    public void setUp() {
     //truckMapper.addNewTruck("BMW", "m3", 2000, "aa-11-bb", 100);
     //truckMapper.addNewTruck("Porsche", "carrera", 2010, "bb-22-cc", 120);
    }
    



    @After
    public void tearDown() {
        truckMapper.getConnection().closeDatabaseConnection();
    }
    
    
    
    
    @Test
    public void testGetTruckNumber(){
      
      int trucknumber = truckMapper.getTruckNumber("aa-11-bb");
      int expected = trucknumber+1;
      int actual = truckMapper.getTruckNumber("bb-22-cc");
      
      assertEquals("LicensePlate should be: " , expected, actual);
      truckMapper.deleteTruck(1);
      truckMapper.deleteTruck(2);
      
    }

    
    @Test
    public void testGetBrand(){
        String brand = truckMapper.getBrand(truckMapper.getTruckNumber("aa-11-bb"));
        String expected = "BMW";
        assertEquals("its :" ,expected, brand);
        truckMapper.deleteTruck(1);
    }
    
    @Test
    public void testGetBuildYear(){
        int expectedBuildYear = 2010;
        int trucknumber = truckMapper.getBuildYear(5);
        
        assertEquals("Should be ", trucknumber, expectedBuildYear);
    }
    
    
    @Test
    public void testGetLicensePlate() {
    
            String plateNr = truckMapper.getLicensePlate(4);    
            String expected = "aa-11-bb";
            
            assertEquals(expected, plateNr);
        
    }
    
    @Test
    public void testGetTowingCapacity(){
      int expected = 100;
      int towing = truckMapper.getTowingCapacity(4);
      
        assertEquals(expected, 100);
              
    }

    @Test
    public void testSetTruckNumber(){
        truckMapper.addNewTruck("Audi", "a5", 2010, "cc-12-fb", 115);
        truckMapper.setTruckNumber(60, "cc-12-fb");
  
        assertEquals(60, truckMapper.getTruckNumber("cc-12-fb"));
        
        truckMapper.deleteTruck(60);
    } 
    
    @Test
    public void testSetBrand(){
        truckMapper.addNewTruck("Audi", "a5", 2010, "cc-12-fb", 115);
        truckMapper.setTruckNumber(60, "cc-12-fb");
        truckMapper.setBrand("Merzedes", 60);
        
        
        assertEquals("Merzedes", truckMapper.getBrand(60));
        truckMapper.deleteTruck(60);
    }
    
    @Test
    public void testSetModel(){
        
        truckMapper.addNewTruck("Audi", "a5", 2010, "cc-12-fb", 115);
        truckMapper.setTruckNumber(66, "cc-12-fb");
        truckMapper.setModel("Ferrari", 66);
        
        
        assertEquals("Ferrari", truckMapper.getModel(66));
        
        truckMapper.deleteTruck(66);

    }
    
     @Test
     public void testSetBuildYear(){
         
     truckMapper.addNewTruck("Audi", "a5", 2010, "cc-12-fb", 115);
     truckMapper.setTruckNumber(666, "cc-12-fb");
     truckMapper.setBuildYear(1999, 666);
     
         assertEquals(1999, truckMapper.getBuildYear(666));
         truckMapper.deleteTruck(666);
     }
    
     @Test
     public void testSetLicensePlate(){

         truckMapper.addNewTruck("Audi", "a5", 2010, "cc-12-fb", 115);
         truckMapper.setTruckNumber(666, "cc-12-fb");
         
         truckMapper.setLicensePlate("ss-66-ss", 666);
         
         assertEquals("ss-66-ss", truckMapper.getLicensePlate(666));
         truckMapper.deleteTruck(666);
     }
    
   
    @Test
    public void testSetTowingCapacity(){
         truckMapper.addNewTruck("Audi", "a5", 2010, "cc-12-fb", 115);
         truckMapper.setTruckNumber(666, "cc-12-fb");
         
         truckMapper.setTowingCapacity(1000, 666);
         
         assertEquals(1000, truckMapper.getTowingCapacity(666));
         truckMapper.deleteTruck(666);
    }
    
    @Test
    public void testDeleteTruck(){
           truckMapper.addNewTruck("Audi", "a5", 2010, "c2-12-fb", 115);
           truckMapper.setTruckNumber(666, "c2-12-fb");
           truckMapper.deleteTruck(666);
           
           try {
               truckMapper.getTruckNumber("c2-12-fb");
               System.out.println("Deleted Successfully");
              
           } catch (Exception delete) {
               System.out.println("Data deleted.");
           }
               
           }
           
  
    
    public void addNewTruck(){
        
        
        try {
            truckMapper.addNewTruck("Audi", "a5", 2010, "c2-12-fb", 115);
            
        } catch (Exception ex) {
            
        }
    
    }
}
