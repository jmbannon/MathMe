/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package class_resources;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jesse
 */
public class PlaySoundTest {

    private static final String WORKING_FILE = "GUI_LogOn.wav";
    private static final String NON_WORKING_FILE = "GUI_Author.jpg";
    private static final String NON_EXISTANT_FILE = "nope.nope";
    
    /**
     * Test of play method, of class PlaySound.
     */
    @Test
    public void testPlay() {
        PlaySound.play(WORKING_FILE);
        PlaySound.stop();
        PlaySound.play(NON_WORKING_FILE);
        PlaySound.stop();
        PlaySound.play(NON_EXISTANT_FILE);
        PlaySound.stop();
    }
    
    /**
     * Test of stop method, of class PlaySound.
     */
    @Test
    public void testStop() {
        PlaySound.stop();
    } 
}
