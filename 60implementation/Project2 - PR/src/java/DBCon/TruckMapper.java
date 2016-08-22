package DBCon;

import java.sql.PreparedStatement;

/**
 *
 * @author Bas
 */
public class TruckMapper {
    
    private static final DBConnect connection = DBConnect.con;
    private final String tableName = "truck"; //(s)
    
    public TruckMapper(){
        
    }
    
    public DBConnect getConnection() {
        return connection;
    }

    public String getTableName() {
        return tableName;
    }
    
    public int getTruckNumber(String licensePlate){
        return connection.selectIntQuery("truck_nr", tableName, "licenseplate", licensePlate);
    }
    
    public String getBrand(int truckNumber){
        return connection.selectStringQuery("brand", tableName, "truck_nr", truckNumber);
    }
    
    public String getModel(int truckNumber){
        return connection.selectStringQuery("model", tableName, "truck_nr", truckNumber);
    }
    
    public int getBuildYear(int truckNumber){
        return connection.selectIntQuery("buildyear", tableName, "truck_nr", truckNumber);
    }
    
    public String getLicensePlate(int truckNumber){
        return connection.selectStringQuery("licenseplate", tableName, "truck_nr", truckNumber);
    }
    
    public int getTowingCapacity(int truckNumber){
        return connection.selectIntQuery("towing_cap", tableName, "truck_nr", truckNumber);
    }

    public void setTruckNumber(int truckNumber, String licensePlate){
        connection.updateQuery("truck_nr", truckNumber, tableName, "licenseplate", licensePlate);
    }
    
    public void setBrand(String brand, int truckNumber){
        connection.updateQuery("brand", brand, tableName, "truck_nr", truckNumber);
    }
    
    public void setModel(String model, int truckNumber){
        connection.updateQuery("model", model, tableName, "truck_nr", truckNumber);
    }
    
    public void setBuildYear(int buildYear, int truckNumber){
        connection.updateQuery("buildyear", buildYear, tableName, "truck_nr", truckNumber);
    }
    
    public void setLicensePlate(String licensePlate, int truckNumber){
        connection.updateQuery("licenseplate", licensePlate, tableName, "truck_nr", truckNumber);
    }
    
    public void setTowingCapacity(int towingCapacity, int truckNumber){
        connection.updateQuery("towing_cap", towingCapacity, tableName, "truck_nr", truckNumber);
    }
    
    public void deleteTruck(int truckNumber){
        connection.deleteQuery(tableName, "truck_nr", truckNumber);
    }
    
    public static void addNewTruck(String brand, String model, int buildYear, String licensePlate, int towingCapacity){
        try{
            String query = "SELECT addnewtruck( ? , ? , ? , ? , ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, brand);
            preparedStatement.setString(2, model);
            preparedStatement.setInt(3, buildYear);
            preparedStatement.setString(4, licensePlate);
            preparedStatement.setInt    (5, towingCapacity);
            System.out.println(preparedStatement);
            preparedStatement.executeQuery();
        } catch(Exception ex){
            System.out.println(ex); 
        }
    }
}
