/*
 * MathMe is an educational program created by Jesse Bannon for 
 * TCSS 305 at University of Washington Tacoma (Fall Quarter 2014). 
 *
 * It is open source and can be modified, changed, and used in
 * any way so long as Jesse Bannon and MathMe is referenced.
 */
package database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Jesse Bannon
 * @version 1.0
 * 
 * Connects to the MYSqlite database found in the root folded 
 * mathme_database.sqlite.
 */
public class Database {
    
    /** MySQLite Driver Name. */
    private static final String MYSQLite_DRIVER_NAME = "org.sqlite.JDBC";
    
    /** MySQLite Database URL. */  
    private static final String MYSQLite_URL = 
            "jdbc:sqlite:matheme_database.sqlite";
    
    /** MySQLite Username. */
    private static final String MYSQL_USERNAME = "root";
    
    /** MySQLite Password. */;
    private static final String MYSQL_PASSWORD = "password";
    
    /** Does nothing. */
    protected Database() { /* Do nothing */ }
    
    /**
     * Connects to the MySQLite database.
     * 
     * @return Connection to the database.
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws SQLException 
     */
    protected Connection databaseConnection() throws ClassNotFoundException, 
            InstantiationException, IllegalAccessException, SQLException {
        
        try {
            final Class driver_class = Class.forName(MYSQLite_DRIVER_NAME);            
            final Driver driver = (Driver) driver_class.newInstance();
            DriverManager.registerDriver(driver); 
            
            final Connection conn = DriverManager.getConnection
                (MYSQLite_URL, MYSQL_USERNAME , MYSQL_PASSWORD);
            
            return conn; // Connection is successful
            
        } catch(ClassNotFoundException | InstantiationException 
                | IllegalAccessException | SQLException e) {
            
            System.err.println(e.getMessage());
        }
        
        return null; // Connection unsuccessful
    }
}
