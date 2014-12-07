/*
 * MathMe is an educational program created by Jesse Bannon for 
 * TCSS 305 at University of Washington Tacoma (Fall Quarter 2014). 
 *
 * It is open source and can be modified, changed, and used in
 * any way so long as Jesse Bannon and MathMe is referenced.
 */
package question;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 * @author Jesse Bannon
 * @version 1.0
 * 
 * Abstract question type for MathMe tests.
 */
public abstract class Question_Abstract {
    
    private final Question_Type questionType;
    
    private URL imageQuestionURL;
    private Image imageQuestion;    
    private String textQuestion;
    
    /**
     * Sets the type of question.
     * @param type Type of question.
     */
    Question_Abstract(final Question_Type type) {
        this.questionType = type;
    }
    
    /**
     * Sets the question to a text string.
     * @param question string of question.
     */
    public void setTextQuestion(final String question) {
        textQuestion = question;
    }
    
    /**
     * Sets the question to an image.
     * @param filename filename of image within /file_resources/.
     */
    public void setImageQuestion(final String filename) {        
        try {
            imageQuestionURL = this.getClass().getResource("/file_resources/" 
                    + filename);
            
            imageQuestion = ImageIO.read(imageQuestionURL);       
            imageQuestion = imageQuestion.getScaledInstance
                (570, 226, java.awt.Image.SCALE_SMOOTH);
            
        } catch (IOException 
                | IllegalArgumentException 
                | NullPointerException ex) {
            
            System.err.println(ex.getClass() + ": " + ex.getMessage());
            System.err.println("Could not initialize image URL or image");
        }
    }
    
    /**
     * Returns the question text.
     * @return question text.
     */
    public String getQuestionText() {
        return textQuestion;
    }
    
    /**
     * Returns the question image.
     * @return question image.
     */
    public Image getQuestionImage() {
        return imageQuestion;
    }
    
    /**
     * Returns the URL of the question image.
     * @return URL of question image.
     */
    public URL getQuestionImageURL() {
        return imageQuestionURL;
    }
    
    /**
     * Returns the type of question.
     * @return Question type.
     */
    public Question_Type getQuestionType() {
        return questionType;
    }
    
    /**
     * Returns the first answer option.
     * @return answer option one.
     */
    public String getAnswer1() {
        /* Implement in Question Types */
        return "ERROR: EMPTY ANSWER";
    }
    
    /**
     * Returns the second answer option.
     * @return answer option two.
     */
    public String getAnswer2() {
        /* Implement in Question Types */
        return "ERROR: EMPTY ANSWER";
    }
    
    /**
     * Returns the third answer option.
     * @return answer option three.
     */
    public String getAnswer3() {
        /* Implement in Question Types */
        return "ERROR: EMPTY ANSWER";
    }
    
    /**
     * Returns the fourth answer option.
     * @return answer option four.
     */
    public String getAnswer4() {
        /* Implement in Question Types */
        return "ERROR: EMPTY ANSWER";
    }
    
    /**
     * Returns whether a question has user input.
     * @return user input.
     */
    public boolean hasInput() {
        /* Implement in Question Types */
        return false;
    }
    
    /**
     * Returns whether the question is correct or not.
     * @return True if correct. False if not correct.
     */
    public boolean gradeQuestion() {
        /* Implement in Question Types */
        return false;
    }
    
    /**
     * Clears user input of the question.
     */
    public void clearInput() { /* Implement in Question Types */ }

}
