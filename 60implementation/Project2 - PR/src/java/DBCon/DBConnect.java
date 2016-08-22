package DBCon;

import java.io.Serializable;
import java.sql.*;

/**
 * Class to connect to the database. Contains helper methods for executing
 * queries.
 */
public class DBConnect implements Serializable {

    private Connection connection;
    private Statement statement;
    private String database = "hblogistics";
    private String username = "herm";
    private String password = "1234";
    private String url = "jdbc:postgresql://localhost:5432/" + database;
    public static DBConnect con = new DBConnect();
    private String query;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    /**
     * Initiates the static database connection
     */
    public DBConnect() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    /**
     * Executes a select query.
     *
     * @param selectFieldName
     * @param tableName
     * @return Object[] - Array of type Object.
     */
    public Object[] selectQuery(String selectFieldName, String tableName) {
        try {
            // *** Start execution of query ***
            query = "SELECT " + selectFieldName + " FROM " + tableName + ";";
            preparedStatement = prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            // *** End execution of query ***

            // *** Start validity checks ***
            if (!resultSet.next()) {
                System.out.println("Query did not return any results.");
                return null;
            }
            // *** End validity checks ***

            // *** Start process query results ***
            Object[] results = (Object[]) resultSet.getArray(selectFieldName).getArray();
            return results;
            // *** End process query results ***
        } catch (SQLException sEx) {
            System.out.println(sEx);
            return null;
        } catch (Exception ex) {
            System.out.println(ex + "hier gaat wat mis");
            return null;
        }
    }

    /**
     * Executes a select query.
     *
     * @param selectFieldName
     * @param tableName
     * @param conditionFieldName
     * @param conditionValue
     * @return
     */
    public String selectStringQuery(String selectFieldName, String tableName, String conditionFieldName, int conditionValue) {
        try {
            // *** Start execution of query ***
            query = "SELECT " + selectFieldName + " FROM " + tableName + " WHERE " + conditionFieldName + " = ?;";
            preparedStatement = prepareStatement(query);
            preparedStatement.setInt(1, conditionValue);
            resultSet = preparedStatement.executeQuery();

            // *** End execution of query ***
            // *** Start validity checks ***       
            if (!resultSet.next()) {
                System.out.println("Query did not return any results.");
                return null;
            }
            // *** End validity checks ***

            // *** Start process query results ***
            String result = resultSet.getString(selectFieldName);
            return result;
            // *** End process query results ***
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    /**
     * Executes a select query.
     *
     * @param selectFieldName
     * @param tableName
     * @param conditionFieldName
     * @param conditionValue
     * @return
     */
    public String selectStringQuery(String selectFieldName, String tableName, String conditionFieldName, String conditionValue) {
        try {
            // *** Start execution of query ***
            query = "SELECT " + selectFieldName + " FROM " + tableName + " WHERE " + conditionFieldName + " = ?;";
            preparedStatement = prepareStatement(query);
            preparedStatement.setString(1, conditionValue);
            resultSet = preparedStatement.executeQuery();

            // *** End execution of query ***
            // *** Start validity checks ***       
            if (!resultSet.next()) {
                System.out.println("Query did not return any results.");
                return null;
            }
            // *** End validity checks ***

            // *** Start process query results ***
            String result = resultSet.getString(selectFieldName);
            return result;
            // *** End process query results ***
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    /**
     * Executes a select query.
     *
     * @param selectFieldName
     * @param tableName
     * @param conditionFieldName
     * @param conditionValue
     * @return
     */
    public int selectIntQuery(String selectFieldName, String tableName, String conditionFieldName, int conditionValue) {
        try {
            // *** Start execution of query ***
            query = "SELECT " + selectFieldName + " FROM " + tableName + " WHERE " + conditionFieldName + " = ?;";
            preparedStatement = prepareStatement(query);
            preparedStatement.setInt(1, conditionValue);
            resultSet = preparedStatement.executeQuery();
            // *** End execution of query ***

            // *** Start validity checks ***       
            if (!resultSet.next()) {
                System.out.println("Query did not return any results.");
                return -1;
            }
            // *** End validity checks ***

            // *** Start process query results ***
            int result = resultSet.getInt(selectFieldName);
            return result;
            // *** End process query results ***
        } catch (Exception ex) {
            System.out.println(ex);
            return -1;
        }
    }

    /**
     * Executes a select query.
     *
     * @param selectFieldName
     * @param tableName
     * @param conditionFieldName
     * @param conditionValue
     * @return
     */
    public int selectIntQuery(String selectFieldName, String tableName, String conditionFieldName, String conditionValue) {
        try {
            // *** Start execution of query ***
            query = "SELECT " + selectFieldName + " FROM " + tableName + " WHERE " + conditionFieldName + " = ?;";
            preparedStatement = prepareStatement(query);
            preparedStatement.setString(1, conditionValue);
            resultSet = preparedStatement.executeQuery();
            // *** End execution of query ***

            // *** Start validity checks ***       
            if (!resultSet.next()) {
                System.out.println("Query did not return any results.");
                return -1;
            }
            // *** End validity checks ***

            // *** Start process query results ***
            int result = resultSet.getInt(selectFieldName);
            return result;
            // *** End process query results ***
        } catch (Exception ex) {
            System.out.println(ex);
            return -2;
        }
    }

    /**
     * Executes an update query.
     *
     * @param updateFieldName
     * @param updateValue
     * @param tableName
     * @param conditionFieldName
     * @param conditionValue
     */
    public void updateQuery(String updateFieldName, String updateValue, String tableName, String conditionFieldName, int conditionValue) {
        try {
            // *** Start execution of query ***
            query = "UPDATE " + tableName + " SET " + updateFieldName + " = ? WHERE " + conditionFieldName + " = ?;";
            preparedStatement = prepareStatement(query);
            preparedStatement.setString(1, updateValue);
            preparedStatement.setInt(2, conditionValue);
            preparedStatement.executeUpdate();
            // *** End execution of query ***
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    /**
     * Executes an update query.
     *
     * @param updateFieldName
     * @param updateValue
     * @param tableName
     * @param conditionFieldName
     * @param conditionValue
     */
    public void updateQuery(String updateFieldName, String updateValue, String tableName, String conditionFieldName, String conditionValue) {
        try {
            // *** Start execution of query ***
            query = "UPDATE " + tableName + " SET " + updateFieldName + " = ? WHERE " + conditionFieldName + " = ?;";
            System.out.println(query);
            preparedStatement = prepareStatement(query);
            preparedStatement.setString(1, updateValue);
            preparedStatement.setString(2, conditionValue);
            preparedStatement.executeUpdate();
            // *** End execution of query ***
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    /**
     * Executes an update query.
     *
     * @param updateFieldName
     * @param updateValue
     * @param tableName
     * @param conditionFieldName
     * @param conditionValue
     */
    public void updateQuery(String updateFieldName, int updateValue, String tableName, String conditionFieldName, String conditionValue) {
        try {
            // *** Start execution of query ***
            query = "UPDATE " + tableName + " SET " + updateFieldName + " = ? WHERE " + conditionFieldName + " = ?;";
            preparedStatement = prepareStatement(query);
            preparedStatement.setInt(1, updateValue);
            preparedStatement.setString(2, conditionValue);
            preparedStatement.executeUpdate();
            // *** End execution of query ***
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    /**
     * Executes an update query.
     *
     * @param updateFieldName
     * @param updateValue
     * @param tableName
     * @param conditionFieldName
     * @param conditionValue
     */
        public void updateQuery(String updateFieldName, int updateValue, String tableName, String conditionFieldName, int conditionValue) {
        try {
            // *** Start execution of query ***
            query = "UPDATE " + tableName + " SET " + updateFieldName + " = ? WHERE " + conditionFieldName + " = ?;";
            preparedStatement = prepareStatement(query);
            preparedStatement.setInt(1, updateValue);
            preparedStatement.setInt(2, conditionValue);
            preparedStatement.executeUpdate();
            // *** End execution of query ***
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    /**
     * Deletes record(s) according to the specified condition.
     *
     * @param tableName
     * @param conditionFieldName
     * @param conditionValue
     */
    public void deleteQuery(String tableName, String conditionFieldName, String conditionValue) {
        try {
            // *** Start execution of query ***
            query = "DELETE FROM " + tableName + " WHERE " + conditionFieldName + " = ?;";
            preparedStatement = prepareStatement(query);
            preparedStatement.setString(1, conditionValue);
            preparedStatement.executeUpdate();
            // *** End execution of query ***
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    /**
     * Deletes record(s) according to the specified condition.
     *
     * @param tableName
     * @param conditionFieldName
     * @param conditionValue
     */
    public void deleteQuery(String tableName, String conditionFieldName, int conditionValue) {
        try {
            // *** Start execution of query ***
            query = "DELETE FROM " + tableName + " WHERE " + conditionFieldName + " = ?;";
            preparedStatement = prepareStatement(query);
            preparedStatement.setInt(1, conditionValue);
            preparedStatement.executeUpdate();
            // *** End execution of query ***
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    /**
     * Executes a specific SQL function without parameters that is already saved
     * in the database.
     *
     * @param functionName
     */
    public void executeFunction(String functionName) {
        //TODO
        try {
            // *** Start execution of query ***
            query = "SELECT " + functionName + "()";
            statement.executeQuery(query);
            // *** End execution of query ***
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public int selectCount(String tableName) {
        try {
            query = "SELECT COUNT(*) FROM " + tableName + ";";
            resultSet = statement.executeQuery(query);

            // *** Start validity checks ***       
            if (!resultSet.next()) {
                System.out.println("Query did not return any results.");
                return -1;
            }
            // *** End validity checks ***

            // *** Start process query results ***
            int result = resultSet.getInt("count");
            return result;
        } catch (Exception ex) {
            System.out.println(ex);
            return -1;
        }
    }

    /**
     * Prevents SQL injections.
     *
     * @param query
     * @return - Returns a prepared statement. Returns null if there's an error.
     */
    public PreparedStatement prepareStatement(String query) {
        try {
            return connection.prepareStatement(query);
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    /**
     * Closes the database connection.
     */
    public void closeDatabaseConnection() {
        try {
            connection.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    /**
     * 
     * @param selectFieldName
     * @param tableName
     * @return ResultSet this set contains all the items of a certain @fieldname from the @tablename. 
     */
    public ResultSet selectResultSetQuery(String selectFieldName, String tableName) {
        try {
            // *** Start execution of query ***
            query = "SELECT " + selectFieldName + " FROM " + tableName + ";";
            System.out.println(query);
            preparedStatement = prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            // *** End execution of query ***
            // *** Start validity checks ***       
            // *** End validity checks ***
            // *** Start process query results ***
            return resultSet;
            // *** End process query results ***
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }
    /**
     * @param selectFieldName
     * @param tableName
     * @param conditionFieldName
     * @param conditionValue
     * @return ResultSet this set contains all the items of a certain @fieldname from the @tablename. with a certain @conditionFieldName and an @value for tha condition
     */
    public ResultSet selectResultSetQuery(String selectFieldName, String tableName,String conditionFieldName, int conditionValue) {
        try {
            // *** Start execution of query ***
            query = "SELECT " + selectFieldName + " FROM " + tableName + " WHERE " + conditionFieldName + " = ?;";
            
            preparedStatement = prepareStatement(query);
            preparedStatement.setInt(1,conditionValue);
            System.out.println(preparedStatement);
            resultSet = preparedStatement.executeQuery();

            // *** End execution of query ***
            // *** Start validity checks ***       
            // *** End validity checks ***
            // *** Start process query results ***
            return resultSet;
            // *** End process query results ***
        } catch (Exception ex) {
            System.out.println(ex);
            return null;
        }
    }
}
