/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static question.Question_Type.CHECK_BOX;

/**
 *
 * @author Jesse
 */
public class Question_AbstractTest {
    
    private Question_Abstract question;
    
    @Before
    public void setUp() {
        question = new Question_CheckBox();
    }

    /**
     * Test of setTextQuestion method, of class Question_Abstract.
     */
    @Test
    public void testSetTextQuestion() {
        question.setTextQuestion("test");
        assertEquals("test", question.getQuestionText());
    }

    /**
     * Test of setImageQuestion method, of class Question_Abstract.
     */
    @Test
    public void testSetImageQuestionExists() {
        question.setImageQuestion("GUI_Author.jpg");
    }
    
    /**
     * Test of setImageQuestion method, of class Question_Abstract.
     */
    @Test
    public void testSetImageQuestionBadExists() {
        question.setImageQuestion("GUI_LogOn.wav");
    }
    
    /**
     * Test of setImageQuestion method, of class Question_Abstract.
     */
    @Test
    public void testSetImageQuestionDoesNotExists() {
        question.setImageQuestion("nope.nope");
    }

    /**
     * Test of getQuestionImageURL method, of class Question_Abstract.
     */
    @Test
    public void testGetQuestionImageURL() {
        question.getQuestionImageURL();
    }

    /**
     * Test of getQuestionType method, of class Question_Abstract.
     */
    @Test
    public void testGetQuestionType() {
        assertEquals(CHECK_BOX.toString(), question.getQuestionType());
    }

    /**
     * Test of getAnswer1 method, of class Question_Abstract.
     */
    @Test
    public void testGetAnswer1() {
        question.getAnswer1();
    }

    /**
     * Test of getAnswer2 method, of class Question_Abstract.
     */
    @Test
    public void testGetAnswer2() {
        question.getAnswer2();
    }

    /**
     * Test of getAnswer3 method, of class Question_Abstract.
     */
    @Test
    public void testGetAnswer3() {
        question.getAnswer3();
    }

    /**
     * Test of getAnswer4 method, of class Question_Abstract.
     */
    @Test
    public void testGetAnswer4() {
        question.getAnswer4();
    }

    /**
     * Test of hasInput method, of class Question_Abstract.
     */
    @Test
    public void testHasInput() {
        question.hasInput();
    }

    /**
     * Test of gradeQuestion method, of class Question_Abstract.
     */
    @Test
    public void testGradeQuestion() {
        question.gradeQuestion();
    }

    /**
     * Test of clearInput method, of class Question_Abstract.
     */
    @Test
    public void testClearInput() {
        question.clearInput();
    }

    public class Question_AbstractImpl extends Question_Abstract {

        public Question_AbstractImpl() {
            super(null);
        }
    }
    
}
