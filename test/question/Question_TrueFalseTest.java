/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jesse
 */
public class Question_TrueFalseTest {
    
    private Question_TrueFalse question;
    
    @Before
    public void setUp() {
        question = new Question_TrueFalse();
    }

    /**
     * Test of setInput method, of class Question_TrueFalse.
     */
    @Test
    public void testSetInput() {
        question.setInput(true);
        assertEquals(2, question.getInput());
    }

    /**
     * Test of hasInput method, of class Question_TrueFalse.
     */
    @Test
    public void testHasNoInput() {
        question.setAnswer(true);
        assertEquals(false, question.hasInput());
    }
    
    /**
     * Test of hasInput method, of class Question_TrueFalse.
     */
    @Test
    public void testHasInputTrue() {
        question.setAnswer(true);
        question.setInput(true);
        assertEquals(true, question.hasInput());
    }
    
    /**
     * Test of hasInput method, of class Question_TrueFalse.
     */
    @Test
    public void testHasInputFalse() {
        question.setAnswer(true);
        question.setInput(false);
        assertEquals(true, question.hasInput());
    }

    /**
     * Test of gradeQuestion method, of class Question_TrueFalse.
     */
    @Test
    public void testGradeQuestionNoInput() {
        question.setAnswer(false);
        assertEquals(false, question.gradeQuestion());
    }
    
    /**
     * Test of gradeQuestion method, of class Question_TrueFalse.
     */
    @Test
    public void testGradeQuestionFalseInput() {
        question.setAnswer(true);
        question.setInput(false);
        assertEquals(false, question.gradeQuestion());
    }
    
    /**
     * Test of gradeQuestion method, of class Question_TrueFalse.
     */
    @Test
    public void testGradeQuestionTrueInput() {
        question.setAnswer(true);
        question.setInput(true);
        assertEquals(true, question.gradeQuestion());
    }

    /**
     * Test of clearInput method, of class Question_TrueFalse.
     */
    @Test
    public void testClearInput() {
        question.setInput(false);
        question.clearInput();
        assertEquals(false, question.hasInput());
    }
    
}
