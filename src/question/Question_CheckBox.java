/*
 * MathMe is an educational program created by Jesse Bannon for 
 * TCSS 305 at University of Washington Tacoma (Fall Quarter 2014). 
 *
 * It is open source and can be modified, changed, and used in
 * any way so long as Jesse Bannon and MathMe is referenced.
 */
package question;

import static question.Question_Type.CHECK_BOX;

/**
 * @author Jesse Bannon
 * @version 1.0
 * 
 * Check box question type for MathMe tests.
 */
public class Question_CheckBox extends Question_Abstract {

    private String answerOne;
    private String answerTwo;
    private String answerThree;
    private String answerFour;
    
    private boolean checkBoxInputOne;
    private boolean checkBoxInputTwo;
    private boolean checkBoxInputThree;
    private boolean checkBoxInputFour;
    
    private boolean checkBoxAnswerOne;
    private boolean checkBoxAnswerTwo;
    private boolean checkBoxAnswerThree;
    private boolean checkBoxAnswerFour;
    
    /**
     * Sets the question type to CHECK_BOX and initializes values all to
     * false, 0, or blank.
     */
    public Question_CheckBox() {
        super(CHECK_BOX);
        answerOne = "";
        answerTwo = "";
        answerThree = "";
        answerFour = "";
        
        /* Bools for checkbox answers */
        checkBoxAnswerOne = false;
        checkBoxAnswerTwo = false;
        checkBoxAnswerThree = false;
        checkBoxAnswerFour = false;
        
        /* Bools for checkbox input */
        checkBoxInputOne = false;
        checkBoxInputTwo = false;
        checkBoxInputThree = false;
        checkBoxInputFour = false;
    }
    
    /**
     * Sets the answer of a CHECK_BOX question type.
     * @param answer1 Answer option 1.
     * @param checkAnswer1 If answer option 1 is correct.
     * @param answer2 Answer option 2.
     * @param checkAnswer2 If answer option 2 is correct.
     * @param answer3 Answer option 3.
     * @param checkAnswer3 If answer option 3 is correct.
     * @param answer4 Answer option 4.
     * @param checkAnswer4 If answer option 4 is correct.
     */
    public void setAnswer(final String answer1, final boolean checkAnswer1, 
        final String answer2, final boolean checkAnswer2, 
        final String answer3, final boolean checkAnswer3, 
        final String answer4, final boolean checkAnswer4) {
        
        answerOne = answer1;
        answerTwo = answer2;
        answerThree = answer3;
        answerFour = answer4;
        
        checkBoxAnswerOne = checkAnswer1;
        checkBoxAnswerTwo = checkAnswer2;
        checkBoxAnswerThree = checkAnswer3;
        checkBoxAnswerFour = checkAnswer4;        
    }
    
    /**
     * Sets the first check box input to true if selected.
     * @param input First check box is selected.
     */
    public void setCheckBoxInputOne(final boolean input) {
        checkBoxInputOne = input;
    }
    
    /**
     * Sets the second check box input to true if selected.
     * @param input Second check box is selected.
     */
    public void setCheckBoxInputTwo(final boolean input) {
        checkBoxInputTwo = input;
    }
    
    /**
     * Sets the third check box input to true if selected.
     * @param input Third check box is selected.
     */
    public void setCheckBoxInputThree(final boolean input) {
        checkBoxInputThree = input;
    }
    
    /**
     * Sets the fourth check box input to true if selected.
     * @param input Fourth check box is selected.
     */
    public void setCheckBoxInputFour(final boolean input) {
        checkBoxInputFour = input;
    }
    
    /**
     * {@inheritDoc}
     * @return Answer option one.
     */
    @Override
    public String getAnswer1() {
        return answerOne;
    }
    
    /**
     * {@inheritDoc}
     * @return Answer option two.
     */
    @Override
    public String getAnswer2() {
        return answerTwo;
    }
    
    /**
     * {@inheritDoc}
     * @return Answer option three.
     */
    @Override
    public String getAnswer3() {
        return answerThree;
    }
    
    /**
     * {@inheritDoc}
     * @return Answer option four.
     */
    @Override
    public String getAnswer4() {
        return answerFour;
    }
    
    /**
     * @return if check box one is selected.
     */
    public boolean getCheckBoxInputOne() {
        return checkBoxInputOne;
    }

    /**
     * @return if check box two is selected.
     */
    public boolean getCheckBoxInputTwo() {
        return checkBoxInputTwo;
    }
    
    /**
     * @return if check box three is selected.
     */
    public boolean getCheckBoxInputThree() {
        return checkBoxInputThree;
    }
    
    /**
     * @return if check box four is selected.
     */
    public boolean getCheckBoxInputFour() {
        return checkBoxInputFour;
    }
    
    /**
     * {@inheritDoc}
     * @return If question has input.
     */
    @Override
    public boolean hasInput() {
        return checkBoxInputOne || checkBoxInputTwo
            || checkBoxInputThree || checkBoxInputFour;
    }
    
    /**
     * {@inheritDoc}
     * @return If question is correct or not.
     */
    @Override
    public boolean gradeQuestion() {
        return checkBoxInputOne == checkBoxAnswerOne &&
                checkBoxInputTwo == checkBoxAnswerTwo &&
                checkBoxInputThree == checkBoxAnswerThree &&
                checkBoxInputFour == checkBoxAnswerFour;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void clearInput() {
        checkBoxInputOne = false;
        checkBoxInputTwo = false;
        checkBoxInputThree = false;
        checkBoxInputFour = false;
    }
    
}
