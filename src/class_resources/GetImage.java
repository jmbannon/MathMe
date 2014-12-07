/*
 * MathMe is an educational program created by Jesse Bannon for 
 * TCSS 305 at University of Washington Tacoma (Fall Quarter 2014). 
 *
 * It is open source and can be modified, changed, and used in
 * any way so long as Jesse Bannon and MathMe is referenced.
 */
package class_resources;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 * @author Jesse Bannon
 * @version 1.0
 * 
 * Returns an image found within the file_resources package.
 */
public class GetImage {
    
    /**
     * Does nothing. Do not use.
     */
    private GetImage() { /* Do nothing. */ }
    
    /**
     * Returns the image of the specified file name from the file_resources
     * package.
     * @param fileName Image file name.
     * @return Returns the image.
     */
    public static Image returnImage(final String fileName) {
        try {
            final URL url = GetImage.class.getResource("/file_resources/" 
                    + fileName);
            final Image image = ImageIO.read(url);       

            return image;
            
        } catch (IOException | IllegalArgumentException 
                | NullPointerException ex) {
            
            System.err.println(ex.getClass() + ": " + ex.getMessage());
            System.err.println("Could not initialize image URL or image");
            return null;
        }
    }
}
