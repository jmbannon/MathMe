
/*
 * MathMe is an educational program created by Jesse Bannon for 
 * TCSS 305 at University of Washington Tacoma (Fall Quarter 2014). 
 *
 * It is open source and can be modified, changed, and used in
 * any way so long as Jesse Bannon and MathMe is referenced.
 */
package class_resources;

/**
 * @author Jesse Bannon
 * @version 1.0
 * 
 * Retrieves system's OS.
 */
public class GetOS {
    
    private static String OS = null;
    
    /**
     * Does nothing. Do not use.
     */
    private GetOS() { /* Do not use. */ }
    
    /**
     * Gets the Operating system's name.
     * @return Operating system name.
     */
    public static String getOSName() {
        if (OS==null) 
            OS = System.getProperty("os.name");   
        
        return OS;
    }
    
    /**
     * @return True if OS is Windows. False if OS is not Windows.
     */
    public static boolean isWindows() {
        return getOSName().startsWith("Windows");
    }
    
    /**
     * @return True if OS is Linux. False if OS is not Linux.
     */
    public static boolean isUnix() {
        return getOSName().startsWith("Linux");
    }   
}
