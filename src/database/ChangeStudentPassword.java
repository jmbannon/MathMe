/*
 * MathMe is an educational program created by Jesse Bannon for 
 * TCSS 305 at University of Washington Tacoma (Fall Quarter 2014). 
 *
 * It is open source and can be modified, changed, and used in
 * any way so long as Jesse Bannon and MathMe is referenced.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Jesse Bannon
 * @version 1.0
 * 
 * Allows the user to change their password by writing a new one into the
 * database.
 */
public class ChangeStudentPassword extends Database {

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    
    private final StudentLogin s1;
    
    /**
     * Initializes the user's login credentials.
     */
    public ChangeStudentPassword() {
        s1 = new StudentLogin();
    }
    
    /**
     * Verifies the user's current password stored in the database.
     * 
     * @param password User's current password.
     * @return 1 if the password is verified. 0 if the password is not verified. -1 if an exception was thrown.
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws SQLException 
     */
    public int verifyCurrentPassword(final String password)
        throws ClassNotFoundException, InstantiationException, 
            IllegalAccessException, SQLException {
        
        try {
            connection = databaseConnection();
            statement = connection.createStatement(); 
            
            final String SQL = "SELECT USERNAME,PASSWORD FROM students WHERE USERNAME='" 
                    + s1.getUsername() + "' and PASSWORD='" + password + "'";            
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();
            
            // Checks Username and Password
            if (resultSet.next()) {
                return 1; // Password entered matches
            }
            
            System.out.println("Incorrect Password\n----");
            return 0; // Password entered did not match 

        } catch (SQLException e) { 
            System.err.println("Exception Occured. SQL State: " 
                    + e.getSQLState()); 
            System.err.println(e.getMessage());
    
        } finally { // Closes all connections if they are not null
            if (connection != null) connection.close();
            if (statement != null) statement.close();
            if (preparedStatement != null) preparedStatement.close();
            if (resultSet != null) resultSet.close();     
        }
        
       return -1; // Returned if exception was thrown
    }
    
    /**
     * Changes the password by writing into the user's password column of the
     * database.
     * 
     * @param password User's new password.
     * @return 1 if password changes successfully. 0 or -1 if exception thrown.
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws SQLException 
     */
    public int changePassword(final String password) 
            throws ClassNotFoundException, InstantiationException, 
            IllegalAccessException, SQLException {
        
        try {
            connection = databaseConnection();            
            statement = connection.createStatement();                         
            statement.executeUpdate("UPDATE students SET PASSWORD='" + password 
                    + "' WHERE USERNAME='" + s1.getUsername() + "'");
           
            return 1; // Changes password successfully
            
        } catch (SQLException e) { 
            System.err.println("Exception Occured. SQL State: " 
                    + e.getSQLState()); 
            System.err.println(e.getMessage()); 
            
            if (e.getSQLState().startsWith("23")) 
                return 0; // Identical username
            
            else 
                return -1; // Error connecting to database
            
        } finally {
            if (connection != null) connection.close();
            if (statement != null) statement.close();
        }
    }
}
