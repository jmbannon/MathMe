/*
 * MathMe is an educational program created by Jesse Bannon for 
 * TCSS 305 at University of Washington Tacoma (Fall Quarter 2014). 
 *
 * It is open source and can be modified, changed, and used in
 * any way so long as Jesse Bannon and MathMe is referenced.
 */
package class_resources;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * @author Jesse Bannon
 * @version 1.0
 * 
 * Creates a countdown timer of specified seconds and passes it to a JLabel.
 */
public class CountdownTimer {
    
    private final Timer timer;
    private final JLabel label;
    private int secondsRemaining; 
   
    /**
     * Creates a countdown timer using milliseconds and displays it to a JLabel.
     * @param totalMilliseconds amount of milliseconds for the timer.
     * @param jlabel JLabel to display time on.
     */
    public CountdownTimer(final int totalMilliseconds, final JLabel jlabel)
            throws IllegalArgumentException {
        
        if (totalMilliseconds < 0)
            throw new IllegalArgumentException("CountdownTimer cannot have "
                    + "negative time.");
            
        label = jlabel;
        secondsRemaining = totalMilliseconds/1000;
        
        //Display beginning time
        if (secondsRemaining >= 10) 
            label.setText("0:" + secondsRemaining);
        else if (secondsRemaining < 10)
            label.setText("0:0" + secondsRemaining);
        
        timer = new Timer(1000, new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {    
                secondsRemaining--;
                
                //Display time
                if (secondsRemaining >= 10) 
                    label.setText("0:" + secondsRemaining);
                else if (secondsRemaining < 10)
                    label.setText("0:0" + secondsRemaining);
                
                if (secondsRemaining == 4)
                    PlaySound.play("FlashMath_Timer.wav");
                
                //End of timer
                if (secondsRemaining <= 0) {
                    stop();
                }
            }      
        });
        timer.start();
    }
    
    /**
     * Returns the seconds remaining.
     * @return Seconds remaining.
     */
    public int getSecondsRemaining() {
        return secondsRemaining;
    }
    
    /**
     * Stops the timer by setting secondsRemaining to 0.
     */
    public void stop() {
        timer.stop();
        label.setText("Time!");
        secondsRemaining = 0;
    }
}