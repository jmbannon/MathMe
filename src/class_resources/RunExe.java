/*
 * MathMe is an educational program created by Jesse Bannon for 
 * TCSS 305 at University of Washington Tacoma (Fall Quarter 2014). 
 *
 * It is open source and can be modified, changed, and used in
 * any way so long as Jesse Bannon and MathMe is referenced.
 */
package class_resources;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * @author Jesse Bannon
 * @version 1.0
 * 
 * Runs the asteroids.exe found in /resources/asteroids/main.
 */
public class RunExe {
    
    /** Path of asteroids. */
    private static final String PATH = "resources/asteroids/main";
    
    /**
     * Does nothing. Do not use.
     */
    private RunExe() { /* Do nothing */ }
    
    /**
     * Runs asteroids.exe.
     * @param parentComponent Component to display JOptionPane.
     * @throws IOException If asteroids.exe cannot be found.
     */
    public static void run(final Component parentComponent) throws IOException {
        if (GetOS.isWindows()) {
            new Thread(new Runnable() {

                @Override public void run() {
                    try {
                        final Runtime rt = Runtime.getRuntime();
                        final File file = new File(PATH);
                    
                        if (! file.exists()) 
                            throw new IllegalArgumentException("The file " 
                                    + PATH + " does not exist");
                    
                        final Process p = rt.exec("cmd /c start Asteroids.exe", 
                                null, file.getAbsoluteFile());
               
                    } catch (IllegalArgumentException | IOException ex) {
                        System.err.println(ex.getClass() + ": " + ex.getMessage());
                        System.err.println("for the file at " + PATH);
                    }
                }
            }).start();
            
        } else
            JOptionPane.showMessageDialog(parentComponent, "Asteroids is only "
                + "compatible with Windows operating systems.");         
    }
}
