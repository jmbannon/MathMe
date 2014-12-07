/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games;

import static games.FlashMath_Difficulty.MEDIUM;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLabel;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jesse
 */
public class FlashMath_MainTest {
    
    /** CheckBox Item for testing */
    private static final JCheckBoxMenuItem checkBoxItem = new JCheckBoxMenuItem();
    
    /** Label for testing */
    private static final JLabel label = new JLabel();
    
    private FlashMath_Main main;
    
    
    
    @Before
    public void setUp() {
        main = new FlashMath_Main();
    }

    /**
     * Test of addSubjectCheckBoxItem method, of class FlashMath_Main.
     */
    @Test
    public void testAddSubjectCheckBoxItem() {
        main.addSubjectCheckBoxItem(checkBoxItem);
    }

    /**
     * Test of submitButtonAction method, of class FlashMath_Main.
     */
    @Test
    public void testSubmitButtonActionUserInGame() {
        main.setUserInGame(true);
        main.submitButtonAction();
    }
    
    /**
     * Test of submitButtonAction method, of class FlashMath_Main.
     */
    @Test
    public void testSubmitButtonActionUserNotInGame() {
        main.setUserInGame(false);
        main.submitButtonAction();
    }
    
    /**
     * Test of submitButtonAction method, of class FlashMath_Main.
     */
    @Test
    public void testSubmitButtonActionGameOver() {
        main.setGameOver(true);
        main.submitButtonAction();
    }
    
    /**
     * Test of submitButtonAction method, of class FlashMath_Main.
     */
    @Test
    public void testSubmitButtonActionGameNotOver() {
        main.setGameOver(false);
        main.submitButtonAction();
    }

    /**
     * Test of setTimerLabel method, of class FlashMath_Main.
     */
    @Test
    public void testSetTimerLabel() {
        main.setTimerLabel(label);
    }

    /**
     * Test of setQuestionLabel method, of class FlashMath_Main.
     */
    @Test
    public void testSetQuestionLabel() {
        main.setQuestionLabel(label);
    }

    /**
     * Test of setDifficulty method, of class FlashMath_Main.
     */
    @Test
    public void testSetDifficulty() {
        main.setDifficulty(MEDIUM);
        assertEquals(MEDIUM, main.getDifficulty());
    }

    /**
     * Test of setInputTextFieldString method, of class FlashMath_Main.
     */
    @Test
    public void testSetInputTextFieldString() {
        main.setInputTextFieldString("test");
        assertEquals("test", main.getInputTextFieldString());
    }

    /**
     * Test of setGameOver method, of class FlashMath_Main.
     */
    @Test
    public void testSetGameOver() {
        main.setGameOver(true);
        assertEquals(true, main.getGameOver());
    }

    /**
     * Test of setUserInGame method, of class FlashMath_Main.
     */
    @Test
    public void testSetUserInGame() {
        main.setUserInGame(true);
        assertEquals(true, main.getUserInGame());
    }


    /**
     * Test of getInputTextFieldEditable method, of class FlashMath_Main.
     */
    @Test
    public void testGetInputTextFieldEditable() {
        main.getInputTextFieldEditable();
    }

    /**
     * Test of getQuestionLabelText method, of class FlashMath_Main.
     */
    @Test
    public void testGetQuestionLabelText() {
        main.getQuestionLabelText();
    }

    /**
     * Test of getSubmitButtonText method, of class FlashMath_Main.
     */
    @Test
    public void testGetSubmitButtonText() {
        main.getSubmitButtonText();
    }

    /**
     * Test of getScoreLabelText method, of class FlashMath_Main.
     */
    @Test
    public void testGetScoreLabelText() {
        main.getScoreLabelText();
    }

    /**
     * Test of getLivesLabelText method, of class FlashMath_Main.
     */
    @Test
    public void testGetLivesLabelText() {
        main.getLivesLabelText();
    }
    
}
