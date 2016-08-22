package DBCon;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerMapper {
    private static final DBConnect connection = DBConnect.con;
    private final String tableName = "customer";
    
    public CustomerMapper(){
        
    }

    public DBConnect getConnection() {
        return connection;
    }
    
    public String getName(int id){
        return connection.selectStringQuery("name", tableName, "id", id);
    }
    
    public String getPhoneNumber(int id){
        return connection.selectStringQuery("phone_nr", tableName, "id", id);
    }
    
    public String getEmail(int id){
        return connection.selectStringQuery("email", tableName, "id", id);
    }
    
    public int getLocationNumber(int id){
        return connection.selectIntQuery("location_nr", tableName, "id", id);
    }
    /**
    This method returns the id of an customer. Since this is only in the database in which this field is he primary key in, this method will need all other information of the customer.
    @param name the name of the customer you want to get the id for
    @param phoneNumber the phone number where you want to get the id for
    @param email the email adress you want to get the id for
    @return int this method returns the id of the customer as an Integer
    **/
    public int getId(String name, String phoneNumber, String email){
        try{
            String query = "SELECT id FROM customer WHERE name = ? AND phone_nr = ? AND email = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phoneNumber);
            preparedStatement.setString(3, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                System.out.println("Query did not return any results.");
                return -1;
            }
            int result = resultSet.getInt("id");
            return result;
        } catch(Exception ex){
            System.out.println(ex);
            return -1;
        }
    }
    /**
    This method deletes all customers with the same name from the list.
    @param customername the name of the customer you want to delete
    **/
    public void deleteCustomer(String customername){
        connection.deleteQuery(tableName, "name", customername);
    }
    /**
    This method creates a new user in the database which has a function addnewcustomer with the same parameters.
    The connection is static so can be reached anytime.
    @param name The name of a new customer
    @param phoneNumber the phonenumber of a new customer
    @param email the email adress of a new customer
    @param locationNumber the number of the location fetched from the database where fthis customer is located at.  
    **/
    public static void addNewCustomer(String name, String phoneNumber, String email, int locationNumber){
        try{
            String query = "SELECT addnewcustomer( ? , ? , ? , ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phoneNumber);
            preparedStatement.setString(3, email);
            preparedStatement.setInt(4, locationNumber);
            preparedStatement.executeQuery();
        } catch(Exception ex){
            System.out.println(ex); 
        }
    }
    
    public void setName(int id, String name){
        connection.updateQuery("name", name, tableName, "id", id);
    }
    
    public void setPhoneNumber(int id, String phoneNumber){
        connection.updateQuery("phone_nr", phoneNumber, tableName, "id", id);
    }
    
    public void setEmail(int id, String email){
        connection.updateQuery("email", email, tableName, "id", id);
    }
    
    public void setLocationNumber(int id, int locationNumber){
        connection.updateQuery("location_nr", locationNumber, tableName, "id", id);
    }
    
    public void deleteCustomer(int id){
        connection.deleteQuery(tableName, "id", id);
    }   
}