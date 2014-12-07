/*
 * MathMe is an educational program created by Jesse Bannon for 
 * TCSS 305 at University of Washington Tacoma (Fall Quarter 2014). 
 *
 * It is open source and can be modified, changed, and used in
 * any way so long as Jesse Bannon and MathMe is referenced.
 */
package tools;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 * @author Jesse Bannon
 * @version 1.0
 * 
 * Backend code to create a simple Paint-like program through a GUI.
 */
public class DrawPad_Main extends JComponent {
    private Image image;  
    private Graphics2D graphics2d;
    
    private int oldX, oldY, currentX, currentY;
    
    private int width = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    private int height = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    
    
    /**
     * Creates a mouse listener to listen for user changes to the image.
     */
    public DrawPad_Main() {
        setDoubleBuffered(false);
                                 
        addMouseListener(new MouseAdapter() {
            @Override public void mousePressed(MouseEvent e) {
                oldX = e.getX();
                oldY = e.getY();
            }
        });
            
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override public void mouseDragged(MouseEvent e) {
                currentX = e.getX();
                currentY = e.getY();
                
                if (graphics2d != null) 
                    graphics2d.drawLine(oldX, oldY, currentX, currentY);
                repaint();
                oldX = currentX;
                oldY = currentY;
            }
        });       
    }
    
    @Override
    public void paintComponent(Graphics g) {
	if (image == null) {
            image = createImage(width, height);
            graphics2d = (Graphics2D)image.getGraphics();
            graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
	}  
        //graphics2d = (Graphics2D)image.getGraphics();
	g.drawImage(image, 0, 0, width, height, null);
        g.dispose();
    }
    
    public void scale(Graphics2D g2) {
        g2.scale(getWidth(), getHeight());
    }
    
    public void clear() {
        final Color origColor = graphics2d.getColor();
        
        graphics2d.setColor(Color.white);
        graphics2d.fillRect(0, 0, width, height);
        repaint();
        
        graphics2d.setColor(origColor);
    }
    
    public void setColor(Color color) {
        graphics2d.setPaint(color);
        repaint();
    }
    
    public void setImage(final File file) throws IOException {
        final Color origColor = graphics2d.getColor();
        image = ImageIO.read(file);
        width = image.getWidth(this);
        height = image.getHeight(this);
        graphics2d = (Graphics2D)image.getGraphics();
        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        repaint();
        graphics2d.setColor(origColor);
    }
    
    public void eraser() {
        graphics2d.setPaint(Color.white);
        repaint();
    }    
}
