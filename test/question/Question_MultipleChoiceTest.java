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
public class Question_MultipleChoiceTest {
    
    private Question_MultipleChoice question;
    
    @Before
    public void setUp() {
        question = new Question_MultipleChoice();
    }

    /**
     * Test of setInput method, of class Question_MultipleChoice.
     */
    @Test
    public void testSetGoodInput() {
        question.setInput(2);
        assertEquals(2, question.getInput());
    }
    
    /**
     * Test of setInput method, of class Question_MultipleChoice.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testSetBadInput() {
        question.setInput(7);
    }

    /**
     * Test of setAnswer method, of class Question_MultipleChoice.
     */
    @Test
    public void testSetGoodAnswer() {
        question.setAnswer("test1", "test2", "test3", "test4", 3);
        assertEquals("test1", question.getAnswer1());
        assertEquals("test2", question.getAnswer2());
        assertEquals("test3", question.getAnswer3());
        assertEquals("test4", question.getAnswer4());
    }
    
    /**
     * Test of setAnswer method, of class Question_MultipleChoice.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testSetBadAnswer() {
        question.setAnswer("test1", "test2", "test3", "test4", 5);
    }
    
    /**
     * Test of hasInput method, of class Question_MultipleChoice.
     */
    @Test
    public void testHasInput() {
        question.setInput(2);
        assertEquals(true, question.hasInput());  
    }
    
    /**
     * Test of hasInput method, of class Question_MultipleChoice.
     */
    @Test
    public void testHasNoInput() {
        assertEquals(false, question.hasInput());
    }

    /**
     * Test of gradeQuestion method, of class Question_MultipleChoice.
     */
    @Test
    public void testGradeCorrectQuestion() {
        question.setAnswer("test1", "test2", "test3", "test4", 1);
        question.setInput(1);
        assertEquals(true, question.gradeQuestion());
    }
    
    /**
     * Test of gradeQuestion method, of class Question_MultipleChoice.
     */
    @Test
    public void testGradeIncorrectQuestion() {
        question.setAnswer("test1", "test2", "test3", "test4", 1);
        question.setInput(3);
        assertEquals(false, question.gradeQuestion());
    }

    /**
     * Test of clearInput method, of class Question_MultipleChoice.
     */
    @Test
    public void testClearInput() {
        question.setInput(3);
        question.clearInput();
        assertEquals(0, question.getInput());
    }
    
}
