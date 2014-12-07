/*
 * MathMe is an educational program created by Jesse Bannon for 
 * TCSS 305 at University of Washington Tacoma (Fall Quarter 2014). 
 *
 * It is open source and can be modified, changed, and used in
 * any way so long as Jesse Bannon and MathMe is referenced.
 */
package class_resources;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;

/**
 * @author Jesse Bannon
 * @version 1.0
 * 
 * Creates a 12x12 color icon.
 */
public class ColorIcon implements Icon {
    
    /** Icon height. */
    static final int HEIGHT = 12; 
    
    /** Icon width. */
    private static final int WIDTH = 12;  
  
    private final Color color;  
  
    /**
     * Sets the color of the icon.
     * @param color Color of the icon.
     */
    public ColorIcon(Color color) {  
        this.color = color;  
    }  
  
    /**
     * Returns the icon height.
     * @return Icon height.
     */
    @Override
    public int getIconHeight() {  
        return HEIGHT;  
    }  
  
    /**
     * Returns the icon width.
     * @return Icon width.
     */
    @Override
    public int getIconWidth() {  
        return WIDTH;  
    }  
  
    /**
     * Paints the icon at the x,y coordinate.
     * @param component Component to display in.
     * @param graphics2d Graphics.
     * @param x X coordinate.
     * @param y Y coordinate.
     */
    @Override
    public void paintIcon(Component component, Graphics graphics2d, 
            int x, int y) {  
        
        graphics2d.setColor(color);  
        graphics2d.fillRect(x, y, WIDTH - 1, HEIGHT - 1);  
  
        graphics2d.setColor(Color.black);  
        graphics2d.drawRect(x, y, WIDTH - 1, HEIGHT - 1);  
    }  
}
