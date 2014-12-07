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
 * Logs a student in through the database with a username and password.
 */
public class StudentLogin extends Database {
    
    /** User's first name. */
    private static String FIRST_NAME;
    
    /** User's last name. */
    private static String LAST_NAME;
    
    /** User's username. */
    private static String USERNAME;
    
    /** User's date of birth. */
    private static String DOB;
    
    /** User's log in status. */
    private static boolean LOGGED_IN;
    
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    
   
    /**
     * Sets MySQLite connection variables to null.
     */
    public StudentLogin() {
        connection = null;
        statement = null;
        preparedStatement = null;
        resultSet = null; 
    }
    
    /**
     * Returns user's first name.
     * @return User's first name.
     */
    public static String getFirstName() {
        return FIRST_NAME;
    }
    
    /**
     * Returns user's last name.
     * @return User's last name.
     */
    public static String getLastName() {
        return LAST_NAME;
    }
    
    /**
     * Returns user's username.
     * @return User's username.
     */
    public static String getUsername() {
        return USERNAME;
    }
    
    /**
     * Returns user's date of birth.
     * @return User's date of birth.
     */
    public static String getDOB() {
        return DOB;
    }
    
    /**
     * Returns user's login status.
     * @return User's log in status.
     */
    public static boolean getLoginStatus() {
        return LOGGED_IN;
    }
    
    /**
     * Logs a user in by matching the username and password to the database.
     * 
     * @param name Login username.
     * @param password Login password.
     * @return True if login was successful. False if login was unsuccessful.
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws SQLException 
     */
    public boolean login(final String name, final String password)
        throws ClassNotFoundException, InstantiationException, 
            IllegalAccessException, SQLException {
        
        try {
            connection = databaseConnection();
            statement = connection.createStatement(); 
            
            final String SQL = "SELECT FIRST_NAME,LAST_NAME,USERNAME,DOB "
                    + "FROM students WHERE USERNAME='" 
                    + name + "' and PASSWORD='" + password + "'";    
            
            preparedStatement = connection.prepareStatement(SQL);
            resultSet = preparedStatement.executeQuery();
            
            // Check Username and Password
            if (resultSet.next()) {
                System.out.println("Successful Login!\n----");
                
                FIRST_NAME = resultSet.getString(1);
                LAST_NAME = resultSet.getString(2);
                USERNAME = resultSet.getString(3);
                DOB = resultSet.getString(4);
                LOGGED_IN = true;
                
                return true; // Login was successful
            }
            
            System.out.println("Incorrect Password\n----");
            return false; // Lagin was unsuccessful

        } catch (SQLException e) { 
            System.err.println("Exception Occured. SQL State: " 
                    + e.getSQLState()); 
            System.err.println(e.getMessage());
    
        } finally {
            if (connection != null) connection.close();
            if (statement != null) statement.close();
            if (preparedStatement != null) preparedStatement.close();
            if (resultSet != null) resultSet.close();     
        }
        
       return false; 
    }
    
    /**
     * Logs the user out and clears out all user info fields.
     */
    public void logout() {
        FIRST_NAME = null;
        LAST_NAME = null;
        USERNAME = null;
        LOGGED_IN = false;
        
        connection = null;
        statement = null;
        preparedStatement = null;
        resultSet = null;
    }
}
