package DBCon;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Bas
 */
public class LocationMapper {
    private static final DBConnect connection = DBConnect.con;
    private final String tableName = "location";
    
    public LocationMapper(){
    }
    
    public DBConnect getConnection() {
        return connection;
    }

    public String getTableName() {
        return tableName;
    }
    /**
     * 
     * @param adress
     * @param city
     * @return location id
     */
    public int getLocationId(String adress, String city){
        try{
            String query = "SELECT id FROM " + tableName + " WHERE adress = ? AND city = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, adress);
            preparedStatement.setString(2, city);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                System.out.println("Query did not return any results.");
                return -1;
            }
            int result = resultSet.getInt("id");
            return result;
        }catch(Exception ex){
            System.out.println(ex);
        }
        
        
        
        return 0;
    }
    
    public String getCompanyName(int locationId){
        return connection.selectStringQuery("company_name", tableName, "id", locationId);
    }
    
    public String getAdress(int locationId){
        return connection.selectStringQuery("adress", tableName, "id", locationId);
    }
    
    public String getCity(int locationId){
        return connection.selectStringQuery("city", tableName, "id", locationId);
    }
    
    public String getCountry(int locationId){
        return connection.selectStringQuery("country", tableName, "id", locationId);
    }
    
    public void setCompanyName(String companyName, int locationId){
        connection.updateQuery("company_name", companyName, tableName, "id", locationId);
    }
    
    public void setAdress(String adress, int locationId){
        connection.updateQuery("adress", adress, tableName, "id", locationId);
    }
    
    public void setCity(String city, int locationId){
        connection.updateQuery("city", city, tableName, "id", locationId);
    }
    
    public void setCountry(String country, int locationId){
        connection.updateQuery("country", country, tableName, "id", locationId);
    }
    
    public void deleteLocation(int locationId){
        connection.deleteQuery(tableName, "id", locationId);
    }
    /**
     * This function adds a location to the database    
     * @param companyName
     * @param adress
     * @param city
     * @param country 
     */
    public static void addNewLocation(String companyName, String adress, String city, String country){
        try{
            String query = "SELECT addnewlocation( ? , ? , ? , ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, companyName);
            preparedStatement.setString(2, adress);
            preparedStatement.setString(3, city);
            preparedStatement.setString(4, country);
            preparedStatement.executeQuery();
        } catch(Exception ex){
            System.out.println(ex); 
        }
    }
}