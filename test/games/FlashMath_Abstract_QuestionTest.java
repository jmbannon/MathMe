/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jesse
 */
public class FlashMath_Abstract_QuestionTest {
    
    /** Used to test doubles */
    private static final double TOLERANCE = 0.000001;
    
    private FlashMath_Abstract_Question question;
    
    
    @Before
    public void setUp() {
        question = new FlashMath_Arithmetic();
    }

    /**
     * Test of generateQuestion method, of class FlashMath_Abstract_Question.
     */
    @Test
    public void testGenerateQuestion() {
        question.generateQuestion();
    }

    /**
     * Test of setTextQuestion method, of class FlashMath_Abstract_Question.
     */
    @Test
    public void testSetTextQuestion() {
        question.setTextQuestion("test");
        assertEquals("test", question.getQuestionText());
    }

    /**
     * Test of setAnswer method, of class FlashMath_Abstract_Question.
     */
    @Test
    public void testSetAnswer() {
        question.setAnswer(4.88);
        assertEquals(4.88, question.getAnswer(), TOLERANCE);
    }

    /**
     * Test of setInput method, of class FlashMath_Abstract_Question.
     */
    @Test
    public void testSetInput() {
        question.setInput("test");
        assertEquals("test", question.getInput());
    }

    /**
     * Test of getDisplayCorrectAnswer method, of class FlashMath_Abstract_Question.
     */
    @Test
    public void testGetDisplayCorrectAnswer() {
        question.getDisplayCorrectAnswer();
    }

    /**
     * Test of getDisplayWrongAnswer method, of class FlashMath_Abstract_Question.
     */
    @Test
    public void testGetDisplayWrongAnswer() {
        question.getDisplayWrongAnswer();
    }

    /**
     * Test of getDisplayNoAnswer method, of class FlashMath_Abstract_Question.
     */
    @Test
    public void testGetDisplayNoAnswer() {
        question.getDisplayWrongAnswer();
    }

    /**
     * Test of getType method, of class FlashMath_Abstract_Question.
     */
    @Test
    public void testGetType() {
        question.getType();
    }

    /**
     * Test of isCorrect method, of class FlashMath_Abstract_Question.
     */
    @Test
    public void testIsCorrect() {
        question.isCorrect();
    }

    public class FlashMath_Abstract_QuestionImpl extends FlashMath_Abstract_Question {

        public FlashMath_Abstract_QuestionImpl() {
            super(null);
        }
    }
    
}
