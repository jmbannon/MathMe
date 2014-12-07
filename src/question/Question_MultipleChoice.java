/*
 * MathMe is an educational program created by Jesse Bannon for 
 * TCSS 305 at University of Washington Tacoma (Fall Quarter 2014). 
 *
 * It is open source and can be modified, changed, and used in
 * any way so long as Jesse Bannon and MathMe is referenced.
 */
package question;

import static question.Question_Type.MULTIPLE_CHOICE;

/**
 * @author Jesse Bannon
 * @version 1.0
 * 
 * Multiple choice question type for MathMe tests.
 */
public class Question_MultipleChoice extends Question_Abstract {
    
    private int input;
    private int answer;
    
    private String answerOne;
    private String answerTwo;
    private String answerThree;
    private String answerFour;
    
    /**
     * Sets question type to MULTIPLE_CHOICE and sets all variables to 0 
     * or blank.
     */
    public Question_MultipleChoice() {
        super(MULTIPLE_CHOICE);
        input = 0;
        answer = 0;
        
        answerOne = "";
        answerTwo = "";
        answerThree = "";
        answerFour = "";
    }
    
    /**
     * Sets multiple choice user input.
     * @param userInput User input of multiple choice.
     * @throws IllegalArgumentException If input < 0 or input > 4.
     */
    public void setInput(final int userInput) throws IllegalArgumentException {
        if (userInput < 0 || userInput > 4)
            throw new IllegalArgumentException("Multiple choice input must "
                    + "be 0 - 4");
        
        input = userInput;
    }
    
    /**
     * Sets all four multiple choice answers as strings.
     * @param answer1 string of first answer.
     * @param answer2 string of second answer.
     * @param answer3 string of third answer.
     * @param answer4 string of fourth answer.
     * @param correctAnswerNum integer indicating which answer is correct. 
     * Must be 1-4.
     */
    public void setAnswer(final String answer1, final String answer2, 
            final String answer3, final String answer4, 
            final int correctAnswerNum) {
        
        if (correctAnswerNum < 1 || correctAnswerNum > 4)
            throw new IllegalArgumentException("Multiple choice answer must "
                    + "be 1 - 4");
            
        answerOne = answer1;
        answerTwo = answer2;
        answerThree = answer3;
        answerFour = answer4;
        answer = correctAnswerNum;
    }   
    
    /**
     * @return User input.
     */
    public int getInput() {
        return input;
    }
    
    /**
     * @return string of the first answer.
     */
    @Override
    public String getAnswer1() {
        return answerOne;
    }
    
    /**
     * @return string of the second answer.
     */
    @Override
    public String getAnswer2() {
        return answerTwo;
    }
    
    /**
     * @return string of the third answer.
     */
    @Override
    public String getAnswer3() {
        return answerThree;
    }
    
    /**
     * @return string of the fourth answer.
     */
    @Override
    public String getAnswer4() {
        return answerFour;
    }
    
    /**
     * {@inheritDoc}
     * @return If question has user input.
     */
    @Override
    public boolean hasInput() {
        return input != 0;
    }
    
    /**
     * {@inheritDoc}
     * @return User input is correct or not.
     */
    @Override
    public boolean gradeQuestion() {
        return (input == answer && input != 0);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void clearInput() {
        input = 0;
    }
}
