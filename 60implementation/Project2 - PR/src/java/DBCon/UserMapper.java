package DBCon;

import java.io.Serializable;
import java.sql.*;

/**
 * Maps the "Users" table from the database to Java.
 * @author Bas
 */
public class UserMapper implements Serializable{
    
    private static final DBConnect connection = DBConnect.con;
    private final String tableName = "users";

    public UserMapper(){
        
    }

    public DBConnect getConnection() {
        return connection;
    }

    public String getTableName() {
        return tableName;
    }
       
    /**
     * Gets the user type.
     * @param id
     * @return - Returns the user type as an integer, 0 if there is an error. TODO 1 = BUSINESS_SUPPORT 2 = CEO 3 = TRUCKDRIVER 4 = ORDER_INVOICE  5 = PLANNING
     */
    public int getUserType(int id){
        return connection.selectIntQuery("usertype", tableName, "id", id);
    }
    
    /**
     * Gets the ID of a user using the username.
     * @param username
     * @return id
     */
    public int getID(String username){
        return connection.selectIntQuery("id", tableName, "username", username);
    }
    
    /**
     * Getter for the username. Creates and executes SQL query.
     * @param id
     * @return username
     */
    public String getUsername(int id){
        return connection.selectStringQuery("username", tableName, "id", id);
    }
    
    /**
     * Gettter for the password. Creates and executes SQL query.
     * @param id
     * @return password
     */
    public String getPassword(int id){
        return connection.selectStringQuery("password", tableName, "id", id);
    }
    /**
     * Logs in the user. 
     * @param username
     * @param password
     * @return - Returns false if there is an error. If details are correct, returns true.
     */
    public boolean login(String username, String password){
        try{
            int id = connection.selectIntQuery("id", tableName, "username", username);
            String actualPassword = getPassword(id);       
            if(actualPassword.equals(password)){
                return true;
            } else {
                System.out.println("Incorrect password");
                return false;
            }
        } catch(Exception ex){
            return false;
        }
    }
    
    /**
     * Sets the username of a user to what is defined using the ID.
     * @param username
     * @param id 
     */
    public void setUsername(String username, int id){
        connection.updateQuery("username", username, tableName, "id", id);
    }
    
    /**
     * Sets the password of a user to what is defined using the ID.
     * @param password
     * @param id 
     */
    public void setPassword(String password, int id){
        connection.updateQuery("password", password, tableName, "id", id);
    }
    
    /**
     * Sets the user type to what is defined by using the ID.
     * @param userType
     * @param id 
     */
    public void setUserType(int userType, int id){
        connection.updateQuery("usertype", userType, tableName, "id", id);
    }
    
    /**
     * Creates a new account with a specified username, password and user type.
     * @param username
     * @param password
     * @param userType 
     */
    public static void createAccount(String username, String password, int userType){
        try{
            String query = "SELECT addnewuser( ? , ? , ? )";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setInt(3, userType);
            preparedStatement.executeQuery();
        } catch(Exception ex){
            System.out.println(ex); 
        }
    }
    
    public void deleteAccount(int id){
        connection.deleteQuery(tableName, "id", id);
    }
}
