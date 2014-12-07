/*
 * MathMe is an educational program created by Jesse Bannon for 
 * TCSS 305 at University of Washington Tacoma (Fall Quarter 2014). 
 *
 * It is open source and can be modified, changed, and used in
 * any way so long as Jesse Bannon and MathMe is referenced.
 */
package database;

import java.awt.Component;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * @author Jesse Bannon
 * @version 1.0
 * 
 * Registers a new user into the database.
 */
public class StudentRegister extends Database {
    
    private Connection connection;
    private Statement statement;
    
    /* Fields for student information. */
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String verifyPassword;
    private String DOB;
    
    /* Ints to be converted into MySQLite date. */
    private int month;
    private int day;
    private int year;
    
    /**
     * Sets all fields to null, blank, or 0.
     */
    public StudentRegister() {
        connection = null;
        statement = null;
        
        firstName = "";
        lastName = "";
        username = "";
        password = "";
        verifyPassword = "";
        DOB = "";
        
        month = 0;
        day = 0;
        year = 0;
    }
    
    /**
     * Sets new user's first name.
     * @param name First name.
     */
    public void setFirstName(final String name) {
        firstName = name.substring(0, 1).toUpperCase() 
            + name.substring(1).toLowerCase();
    }
    
    /**
     * Sets new user's last name.
     * @param name Last name.
     */
    public void setLastName(final String name) {
        lastName = name.substring(0, 1).toUpperCase() 
            + name.substring(1).toLowerCase();
    }
    
    /**
     * Sets new user's username.
     * @param name Username.
     */
    public void setUsername(final String name) {
        username = name;
    }
    
    /**
     * Sets new user's password.
     * @param pass Password.
     */
    public void setPassword(final String pass) {
        password = pass;
    }
    
    /**
     * Sets new user's verification password.
     * @param pass Verification password.
     */
    public void setVerifyPassword(final String pass) {
        verifyPassword = pass;
    }
    
    /**
     * Sets the new user's date of birth.
     * @param theMonth Month of birthday.
     * @param theDay Day of birthday.
     * @param theYear Year of birthday.
     */
    public void setDOB(final String theMonth, final String theDay, 
            final String theYear) {
        
        if (theMonth.equalsIgnoreCase("Month")
                || theDay.equalsIgnoreCase("Day")
                || theYear.equalsIgnoreCase("Year")) {
            month = 0;
            day = 0;
            year = 0;
        }
        
        else {
            month = Integer.parseInt(theMonth);
            day = Integer.parseInt(theDay);
            year = Integer.parseInt(theYear);
        }
        
        // Builds string to match MySQLite Date Format: YYYY-MM-DD
        final StringBuilder birthday = new StringBuilder();
        birthday.append(theYear);
        birthday.append('-');
        birthday.append(theMonth);
        birthday.append('-');
        birthday.append(theDay);
        DOB = birthday.toString();
    }
    
    /**.
     * @return First name of new user.
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * @return Last name of new user.
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * @return Username of new user.
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * @return Password of new user.
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * @return Date of birth of new user.
     */
    public String getDOB() {
        return DOB;
    }
        
    /**
     * Connects to MySQL database and attempts to add the new user's 
     * credentials to the database.
     * 
     * @return 1 if registration is successful. 0 if duplicate username. 
     * -1 if connection failed. 
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException 
     * @throws java.sql.SQLException 
     */
    @SuppressWarnings("ConvertToTryWithResources")
    public int register() throws ClassNotFoundException, 
            InstantiationException, IllegalAccessException, SQLException {
        
        try {
            connection = databaseConnection();            
            statement = connection.createStatement(); 
            statement.executeUpdate("INSERT INTO students " + "VALUES ("
                    + "'" + getFirstName() + "', "
                    + "'" + getLastName() + "', "
                    + "'" + getUsername() + "', " 
                    + "'" + getPassword() + "', " 
                    + "'" + getDOB() + "')"); 
           
            return 1; // Registration is successful
            
        } catch (SQLException e) { 
            System.err.println("Exception Occured. SQL State: " 
                    + e.getErrorCode()); 
            System.err.println(e.getMessage()); 
            
            if (e.getMessage().equalsIgnoreCase("column USERNAME is "
                    + "not unique")) 
                
                return 0; // Identical username
            
            else 
                return -1; // Error connecting to database
            
        } finally {
            if (connection != null) connection.close();
            if (statement != null) statement.close();
            
        }
    }
    
    /**
     * Prompts the user after attempting to register a new account.
     * 
     * @param parentComponent Component for JOptionPane to appear in.
     * @param registerCase Returned integer from function register()
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws SQLException 
     */
    public void registrationPrompt(Component parentComponent, 
            final int registerCase) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException, SQLException {
        
        switch (registerCase) {
            case 1: // Successful login
                JOptionPane.showMessageDialog(parentComponent, 
                        "Registration was successful! Please log in with your "
                        + "new credentials");
                break;
                
            case 0: // Duplicate username
                setUsername(JOptionPane.showInputDialog(parentComponent, 
                        "Username is already in use. Please enter a new "
                            + "username or cancel:\n"));
                
                if (getUsername() == null) return;
                
                while (!verifyUsername(getUsername())) {
                    setUsername(JOptionPane.showInputDialog(parentComponent, 
                            "Username Invalid: Must be at least 4 characters "
                            + "long and must start with a letter."
                            + "\nPlease enter a new username or cancel:\n"));
                    if (getUsername() == null) return;
                }
                
                registrationPrompt(parentComponent, register());
                break;
                
            case -1: // Error connecting to database
                JOptionPane.showMessageDialog(parentComponent, "An error has "
                        + "occured. Please consult your Administrator.");
                break;
                
            default:
                System.out.println("Error");
        }               
    }
    
    /**
     * Verifies if user's registration input syntax is correct. Displays a
     * JOptionPane of each syntax error if there are any.
     * 
     * @param parentComponent Component to display the JOptionPane.
     * @return True if field syntax is correct. False if field syntax is 
     * not correct.
     */
    public boolean verifyAllFields(final Component parentComponent) {
        boolean hasErrors = false;
        final StringBuilder errorMessage = new StringBuilder();
        
        if (!verifyFirstName(firstName)) { 
            errorMessage.append("First Name Invalid: "
                    + "Must contain only letters.\n");
            hasErrors = true;
        }
        
        if (!verifyLastName(lastName)) {
            errorMessage.append("Last Name Invalid: "
                    + "Must contain only letters.\n");
            hasErrors = true;
        }
        
        if (!verifyUsername(username)) {
            errorMessage.append("Username Invalid: "
                    + "Must be at least 4 characters long "
                    + "and must start with a letter.\n");
            hasErrors = true;
        }
        
        if (!verifyPassword(password)) {
            errorMessage.append("Password Invalid: "
                    + "Must be at least 6 characters.\n");
            hasErrors = true;
        }
        
        if (!verifyVerifyPassword(verifyPassword)) {
            errorMessage.append("Password Verification Invalid: "
                    + "Does not match password.\n");
            hasErrors = true;
        }
        
        if (!verifyDateOfBirth(month, day, year)) {
            errorMessage.append("Date of Birth Invalid: Enter a valid date.");
            hasErrors = true;
        }
       
        if (hasErrors) {
            final String completeErrorMessage = errorMessage.toString();
            JOptionPane.showMessageDialog
                (parentComponent, completeErrorMessage);
            return false;
        }
        
        return true;
    }
    
    /**
     * Verifies only user's passwords. Used when the user wants to change their
     * password.
     * 
     * @param parentComponent Component to display the JOptionPane in.
     * @return True if password syntax is verified. False if password syntax 
     * is not verified.
     */
    public boolean verifyPasswords(final Component parentComponent) {
        boolean hasErrors = false;
        final StringBuilder errorMessage = new StringBuilder();
        
        if (!verifyPassword(password)) {
            errorMessage.append("Password Invalid: "
                    + "Must be at least 6 characters.\n");
            hasErrors = true;
        }
        
        if (!verifyVerifyPassword(verifyPassword)) {
            errorMessage.append("Password Verification Invalid: "
                    + "Does not match password.\n");
            hasErrors = true;
        }
        
        if (hasErrors) {
            final String completeErrorMessage = errorMessage.toString();
            JOptionPane.showMessageDialog(parentComponent, 
                    completeErrorMessage);
            
            return false;
        }
        
        return true;
    }
    
    /**
     * Verifies the first name field. Must not be empty, less than 30 
     * characters, and only contain letters.
     * 
     * @param name User's first name.
     * @return True if verified. False if not verified.
     */
    private boolean verifyFirstName(final String name) {
        firstName = name;
        
        // Returns false if empty or is greater than 20 characters
        if (firstName.equals("") || firstName.length() > 30) return false;
        
        final char[] firstNameCharArray = firstName.toCharArray();
        
        // Returns false if anything in firstName is not a letter
        for (char c : firstNameCharArray) {
            if (!Character.isLetter(c)) return false;
        }
        
        // Returns true if verified
        return true;
    }
 
    /**
     * Verifies the last name field. Must not be empty, less than 30 characters,
     * and only contain letters.
     * 
     * @param name User's first name.
     * @return True if verified. False if not verified.
     */    
    private boolean verifyLastName(final String name) {
        lastName = name;
        //Returns false if empty or is greater than 30 characters
        if (lastName.equals("") || lastName.length() > 30) return false;
        
        final char[] lastNameCharArray = lastName.toCharArray();
        
        //Returns false if anything in lastName is not a letter
        for (char c : lastNameCharArray) {
            if (!Character.isLetter(c)) return false;
        }
        return true;
    }
    
    /**
     * Verifies the username field. Must not be greater than 3 characters, less 
     * than 20 characters, start with a letter, and only contain letters or 
     * numbers.
     * 
     * @param username User's username.
     * @return True if verified. False if not verified.
     */
    private boolean verifyUsername(final String username) {
        //Returns false if empty or is greater than 20 characters
        if (username.equals("")
            || username.equalsIgnoreCase("Username")
            || username.length() > 20
            || username.length() < 3) return false;
        
        final char[] usernameArray = username.toCharArray();
        
        //Returns false if first digit is a digit
        if (Character.isDigit(usernameArray[0])) return false;
        
        //Returns false if anything in username is not a letter or digit
        for (char c : usernameArray) {
            if (!(Character.isLetter(c) || Character.isDigit(c))) return false;
        }
        return true;
    }
    
    /**
     * Verifies the password field by making sure it is greater than 5 
     * characters and less than 30 characters.
     * 
     * @param pass User's password.
     * @return True if verified. False if not verified.
     */
    private boolean verifyPassword(String pass) {
       password = pass;
       return (!(password.equals("") 
            || password.equalsIgnoreCase("Password")
            || password.equalsIgnoreCase("Verify Password")
            || password.length() > 30
            || password.length() < 5));     
    }
    
    /**
     * Verifies the verification password field by making sure it matches the
     * password field.
     * @param pass User's verification password.
     * @return True if verified. False if not verified.
     */
    private boolean verifyVerifyPassword(String pass) {
        verifyPassword = pass;
        return password.equals(verifyPassword);
    }
    
    /**
     * Verifies the user's date of birth field by checking if it is a 
     * valid date.
     * 
     * @param theMonth Month of user's birthday.
     * @param theDay Day of user's birthday.
     * @param theYear Year of user's birthday.
     * @return True if verified. False if not verified.
     */
    private boolean verifyDateOfBirth(int theMonth, int theDay, int theYear) {
        month = theMonth;
        day = theDay;
        year = theYear;
        
        return (!(month == 0 || day == 0 || year == 0 
                || month > 12 || day > 31));
    }
}
