/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games;

import static games.FlashMath_Difficulty.HARD;
import static games.FlashMath_Difficulty.MEDIUM;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jesse
 */
public class FlashMath_PlayerTest {
    
    private FlashMath_Player player;
    
    @Before
    public void setUp() {
        player = new FlashMath_Player(MEDIUM);
    }

    /**
     * Test of updatePlayer method, of class FlashMath_Player.
     */
    @Test
    public void testUpdatePlayerTrue() {
        player.updatePlayer(true);
    }
    
    /**
     * Test of updatePlayer method, of class FlashMath_Player.
     */
    @Test
    public void testUpdatePlayerFalse() {
        player.updatePlayer(false);
    }

    /**
     * Test of isAlive method, of class FlashMath_Player.
     */
    @Test
    public void testIsAlive() {
        player.isAlive();
    }

    /**
     * Test of setDifficulty method, of class FlashMath_Player.
     */
    @Test
    public void testSetDifficulty() {
        player.setDifficulty(HARD);
        assertEquals(HARD, player.getDifficulty());
    }

    /**
     * Test of getTimerTime method, of class FlashMath_Player.
     */
    @Test
    public void testGetTimerTime() {
        player.getTimerTime();
    }

    /**
     * Test of getLives method, of class FlashMath_Player.
     */
    @Test
    public void testGetLives() {
        player.getLives();
    }

    /**
     * Test of getScore method, of class FlashMath_Player.
     */
    @Test
    public void testGetScore() {
        player.getScore();
    }
    
}
