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
public class Question_TextBoxTest {
    
    private Question_TextBox question;
    
    @Before
    public void setUp() {
        question = new Question_TextBox();
    }

    /**
     * Test of setInput method, of class Question_TextBox.
     */
    @Test
    public void testSetInput() {
        question.setInput("test");
        assertEquals("test", question.getInput());
    }

    /**
     * Test of getInput method, of class Question_TextBox.
     */
    @Test
    public void testGetNoInput() {
        assertEquals("", question.getInput());
    }
    
    /**
     * Test of getInput method, of class Question_TextBox.
     */
    @Test
    public void testGetInput() {
        question.setInput("input");
        assertEquals("input", question.getInput());
    }

    /**
     * Test of hasInput method, of class Question_TextBox.
     */
    @Test
    public void testHasInput() {
        question.setInput("input");
        assertEquals(true, question.hasInput());
    }
    
    /**
     * Test of hasInput method, of class Question_TextBox.
     */
    @Test
    public void testHasNoInput() {
        assertEquals(false, question.hasInput());
    }

    /**
     * Test of gradeQuestion method, of class Question_TextBox.
     */
    @Test
    public void testGradeQuestion() {
        question.setAnswer("thisAnswer");
        question.setInput("thisAnswer");
        assertEquals(true, question.gradeQuestion());
    }

    /**
     * Test of clearInput method, of class Question_TextBox.
     */
    @Test
    public void testClearInput() {
        question.setInput("safsadf");
        question.clearInput();
        assertEquals(false, question.hasInput());
    }
    
}
