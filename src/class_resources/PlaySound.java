/*
 * MathMe is an educational program created by Jesse Bannon for 
 * TCSS 305 at University of Washington Tacoma (Fall Quarter 2014). 
 *
 * It is open source and can be modified, changed, and used in
 * any way so long as Jesse Bannon and MathMe is referenced.
 */
package class_resources;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * @author Jesse Bannon
 * @version 1.0
 * 
 * Plays .WAV files found within the /resources/sounds/ directory.
 */
public class PlaySound {
    
    /** Path to sound files relative to the .JAR */
    private static final String DIR_PATH = "resources/sounds";
    
    private static Clip clip;
    private static String fullPath;
    
    /**
     * Does nothing. Do not use.
     */
    private PlaySound() { /* Do nothing */ }
    
    /**
     * Plays a .WAV file found within the DIR_PATH relative to the .JAR.
     * @param fileName .WAV file name.
     */
    public static synchronized void play(final String fileName) {
        // Note: use .wav files             
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    final File file = new File(DIR_PATH);
                    
                    clip = AudioSystem.getClip();
                    fullPath = file.getAbsolutePath() + "\\" + fileName;

                    final AudioInputStream inputStream = AudioSystem.
                            getAudioInputStream(new File(fullPath));
                    
                    clip.open(inputStream);
                    clip.start();
                    
                } catch (LineUnavailableException 
                        | UnsupportedAudioFileException 
                        | IOException e) {
                    
                    System.err.println("play sound error: " + e.getMessage() + " for " + fileName);
                    System.err.println("found at " + fullPath);
                }
            }
        }).start();
    }
    
    /**
     * Stops any audio being played.
     */
    public static synchronized void stop() {
        if (clip != null)
            clip.stop();
    }
}
