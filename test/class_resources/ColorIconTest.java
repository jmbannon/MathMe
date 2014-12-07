/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package class_resources;

import java.awt.Color;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Jesse
 */
public class ColorIconTest {
    
    private ColorIcon myIcon;
    private final Color color = Color.BLACK;
    
    private static final int STATIC_COLOR_ICON_WIDTH = 12;
    private static final int STATIC_COLOR_ICON_HEIGHT = 12;
    
    
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() {
        myIcon = new ColorIcon(color);
    }

    /**
     * Test of getIconHeight method, of class ColorIcon.
     */
    @Test
    public void testGetIconHeight() {
        assertEquals(STATIC_COLOR_ICON_HEIGHT, myIcon.getIconHeight());
    }

    /**
     * Test of getIconWidth method, of class ColorIcon.
     */
    @Test
    public void testGetIconWidth() {
        assertEquals(STATIC_COLOR_ICON_WIDTH, myIcon.getIconWidth());
    }
}
