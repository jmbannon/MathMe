/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package class_resources;

import javax.swing.JLabel;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jesse
 */
public class CountdownTimerTest {
    
    private CountdownTimer timer;
    
    private static final int TIME = 1000;
    private static final JLabel LABEL = new JLabel();
    
    @Before
    public void setUp() {
        timer = new CountdownTimer(TIME, LABEL);
    }

    /**
     * Test of getSecondsRemaining method, of class CountdownTimer.
     */
    @Test
    public void testGetSecondsRemaining() {
        assertEquals(TIME/1000, timer.getSecondsRemaining());
    }
    
    /**
     * Test to catch illegal argument exception of negative time
     */
    @Test (expected = IllegalArgumentException.class)
    public void testNewTimerInvalidSeconds() {
        CountdownTimer fail = new CountdownTimer(-44, LABEL);
    }

    /**
     * Test of stop method, of class CountdownTimer.
     */
    @Test
    public void testStop() {
        timer.stop();
        assertEquals(0, timer.getSecondsRemaining());
    }
    
}
