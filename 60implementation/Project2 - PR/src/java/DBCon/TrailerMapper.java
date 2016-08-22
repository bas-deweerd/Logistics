package DBCon;

import java.sql.PreparedStatement;

/**
 *
 * @author Bas
 */
public class TrailerMapper {
    
    private static final DBConnect connection = DBConnect.con;
    private final String tableName = "trailer";
    
    
    public TrailerMapper(){
        
    }
    
    public DBConnect getConnection() {
        return connection;
    }

    public String getTableName() {
        return tableName;
    }
    
    public int getTrailerNumber(String licensePlate){
        return connection.selectIntQuery("trailer_nr", tableName, "licenseplate", licensePlate);
    }

    public String getLicensePlate(int trailerNumber){
        return connection.selectStringQuery("licenseplate", tableName, "trailer_nr", trailerNumber);
    }
    
    public int getLoadingCapacity(int trailerNumber){
        return connection.selectIntQuery("loading_cap", tableName, "trailer_nr", trailerNumber);
    }
    
    public void setLicensePlate(String licensePlate, int trailerNumber){
        connection.updateQuery("licenseplate", licensePlate, tableName, "trailer_nr", trailerNumber);
    }

    public void setLoadingCapacity(int loadingCapacity, int trailerNumber){
        connection.updateQuery("loading_cap", loadingCapacity, tableName, "trailer_nr", trailerNumber);
    }
    
    public void deleteTrailer(int trailerNumber){
        connection.deleteQuery(tableName, "trailer_nr", trailerNumber);
    }
    
    public static void addNewTrailer(String licenseplate, int load_capacity){
        try{
            String query = "SELECT addnewtrailer( ? , ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, licenseplate);
            preparedStatement.setInt(2, load_capacity);
            preparedStatement.executeQuery();
        } catch(Exception ex){
            System.out.println(ex); 
        }
    }
    
    
    
    
}   