/*
 * MathMe is an educational program created by Jesse Bannon for 
 * TCSS 305 at University of Washington Tacoma (Fall Quarter 2014). 
 *
 * It is open source and can be modified, changed, and used in
 * any way so long as Jesse Bannon and MathMe is referenced.
 */
package question;

import static question.Question_Type.TRUE_FALSE;

/**
 * @author Jesse Bannon
 * @version 1.0
 * 
 * True/False question type for MathMe tests.
 */
public class Question_TrueFalse extends Question_Abstract {
    
    private boolean input;
    private boolean hasAnswered;
    
    private boolean answer;
    
    /**
     * Sets question type to TRUE_FALSE and initializes values to false.
     */
    public Question_TrueFalse() {
        super(TRUE_FALSE);
        hasAnswered = false;
        input = false;
    }
    
    /**
     * Sets user input.
     * @param userInput User input. 
     */
    public void setInput(final boolean userInput) {
        input = userInput;
        hasAnswered = true;
    }
    
    /**
     * Sets the correct answer.
     * @param correctAnswer whether the answer is true or false.
     */
    public void setAnswer(final boolean correctAnswer) {
        answer = correctAnswer;
    }
    
    /**
     * @return 2 if input is true. 1 if input is false. 0 if no input.
     */
    public int getInput() {
        if (hasAnswered)
            if (input)
                return 2;
            else
                return 1;
        else
            return 0;
    }
    
    /**
     * {@inheritDoc}
     * @return If question has user input.
     */
    @Override
    public boolean hasInput() {
        return hasAnswered;
    }
    
    /**
     * {@inheritDoc}
     * @return If user input is correct or not.
     */
    @Override
    public boolean gradeQuestion() {
        if (hasAnswered)
            return input == answer;
            
        else
            return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clearInput() {
        hasAnswered = false;
    }
    
}
