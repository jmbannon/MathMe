/*
 * MathMe is an educational program created by Jesse Bannon for 
 * TCSS 305 at University of Washington Tacoma (Fall Quarter 2014). 
 *
 * It is open source and can be modified, changed, and used in
 * any way so long as Jesse Bannon and MathMe is referenced.
 */
package question;

import static question.Question_Type.TEXT_BOX;

/**
 * @author Jesse Bannon
 * @version 1.0
 * 
 * Text box question type for MathMe tests.
 */
public class Question_TextBox extends Question_Abstract {

    private String textInput;
    private String textAnswer;
    
    /**
     * Sets question type to TEXT_BOX and sets variables to blank.
     */
    public Question_TextBox() {
        super(TEXT_BOX);
        textInput = "";
        textAnswer = "";
    }
    
    /**
     * Sets the text answer input by the user.
     * @param input the answer input.
     */
    public void setInput(final String input) {
        textInput = input;
    }
    
    /**
     * Sets answer of question.
     * @param answer Answer of question.
     */
    public void setAnswer(final String answer) {
        textAnswer = answer;
    }
    
    /**
     * @return string of text field input given by the user.
     */
    public String getInput() {
        return textInput;
    }
    
    /**
     * {@inheritDoc}
     * @return If question has user input.
     */
    @Override
    public boolean hasInput() {
        return !textInput.equals("");
    }
    
    /**
     * {@inheritDoc}
     * @return If question is correct or not.
     */
    @Override
    public boolean gradeQuestion() {
        return textInput.equalsIgnoreCase(textAnswer.trim());
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void clearInput() {
        textInput = "";
    }
    
}
