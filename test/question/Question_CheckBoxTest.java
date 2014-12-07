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
public class Question_CheckBoxTest {
    
    private Question_CheckBox checkBox;
    
    @Before
    public void setUp() {
        checkBox = new Question_CheckBox();
    }

    /**
     * Test of setAnswer method, of class Question_CheckBox.
     */
    @Test
    public void testSetAnswer() {
        checkBox.setAnswer("test1", true, "test2", false, "test3", true, "test4", false);
        
        assertEquals("test1", checkBox.getAnswer1());       
        assertEquals("test2", checkBox.getAnswer2());
        assertEquals("test3", checkBox.getAnswer3());
        assertEquals("test4", checkBox.getAnswer4());
    }

    /**
     * Test of setCheckBoxInputOne method, of class Question_CheckBox.
     */
    @Test
    public void testSetCheckBoxInput() {
        checkBox.setCheckBoxInputOne(true);
        checkBox.setCheckBoxInputTwo(false);
        checkBox.setCheckBoxInputThree(true);
        checkBox.setCheckBoxInputFour(false);
        
        assertEquals(true, checkBox.getCheckBoxInputOne());
        assertEquals(false, checkBox.getCheckBoxInputTwo());
        assertEquals(true, checkBox.getCheckBoxInputThree());
        assertEquals(false, checkBox.getCheckBoxInputFour());
    }

    /**
     * Test of hasInput method, of class Question_CheckBox.
     */
    @Test
    public void testHasInput() {
        checkBox.setCheckBoxInputOne(false);
        checkBox.setCheckBoxInputTwo(false);
        checkBox.setCheckBoxInputThree(true);
        checkBox.setCheckBoxInputFour(false);
        
        assertEquals(true, checkBox.hasInput());
    }
    
    /**
     * Test of hasInput method, of class Question_CheckBox.
     */
    @Test
    public void testHasNoInput() {
        checkBox.setCheckBoxInputOne(false);
        checkBox.setCheckBoxInputTwo(false);
        checkBox.setCheckBoxInputThree(false);
        checkBox.setCheckBoxInputFour(false);
        
        assertEquals(false, checkBox.hasInput());
    }

    /**
     * Test of gradeQuestion method, of class Question_CheckBox.
     */
    @Test
    public void testGradeCorrectQuestion() {
        checkBox.setAnswer("test1", true, "test2", false, "test3", true, "test4", false);
        
        checkBox.setCheckBoxInputOne(true);
        checkBox.setCheckBoxInputThree(true);
        
        assertEquals(true, checkBox.gradeQuestion());
    }
    
    /**
     * Test of gradeQuestion method, of class Question_CheckBox.
     */
    @Test
    public void testGradeIncorrectQuestion() {
        checkBox.setAnswer("test1", true, "test2", false, "test3", true, "test4", false);
        
        checkBox.setCheckBoxInputTwo(true);
        checkBox.setCheckBoxInputThree(true);
        
        assertEquals(false, checkBox.gradeQuestion());
    }

    /**
     * Test of clearInput method, of class Question_CheckBox.
     */
    @Test
    public void testClearInput() {
        checkBox.setCheckBoxInputFour(true);
        checkBox.clearInput();
        assertEquals(false, checkBox.hasInput());
    }
    
}
