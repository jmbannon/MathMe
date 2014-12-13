/*
 * MathMe is an educational program created by Jesse Bannon for 
 * TCSS 305 at University of Washington Tacoma (Fall Quarter 2014). 
 *
 * It is open source and can be modified, changed, and used in
 * any way so long as Jesse Bannon and MathMe is referenced.
 */
package question_sets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import question.Question_Abstract;

/**
 * @author Jesse Bannon
 * @version 1.0
 * 
 * Abstract question set for MathMe tests.
 */
public abstract class Set_Abstract {
    
    private final String TEST_NAME;
    private int TEST_SET_SIZE;    
    protected List<Question_Abstract> fullQuestionSet;    
    protected List<Question_Abstract> testQuestionSet;
    
    private int correctQuestions;
    
    /**
     * Constructor creates a question set the size of the parameter 
     * of blank questions 
     * @param name Name of test.
     */
    public Set_Abstract(final String name) {
        TEST_NAME = name;
        fullQuestionSet = new ArrayList<>();
    }
    
    /**
     * Method to fill out questions and answers for every question set.
     */
    protected abstract void fillQuestions();
    
    /**
     * Returns whether a question set has un-submitted questions.
     * @return If question set has un-submitted questions.
     */
    public boolean hasUnsubmittedQuestions() {
        boolean incomplete = false;
        for (Question_Abstract question : testQuestionSet) {
            if (!question.hasInput()) incomplete = true;
        }
        return incomplete;
    }
    
    /**
     * Returns grade percentage of test once submitted.
     * @return Grade percentage.
     */
    public double getGradePercentage() {
        correctQuestions = 0;
        for (Question_Abstract question : testQuestionSet) {
            if (question.gradeQuestion()) 
                ++correctQuestions;
        }
        
        double score = (double)correctQuestions/(double)TEST_SET_SIZE * 100.0;
        return score;
    }
    
    /**
     * Returns the amount of questions correct to amount of total questions.
     * @return Questions correct out of total questions (correct/total).
     */
    public String getQuestionsCorrect() {
        correctQuestions = 0;
        for (Question_Abstract question : testQuestionSet) {
            if (question.gradeQuestion())
                ++correctQuestions;
        }
        
        String questionsCorrect = (correctQuestions + "/" + TEST_SET_SIZE);
        return questionsCorrect;
    }
    
    /**
     * Returns test name.
     * @return Test name.
     */
    public String getTestName() {
        return TEST_NAME;
    }
    
    /**
     * @param numOfQuestions
     * @return the array of questions.
     */
    public List<Question_Abstract> getQuestionSet(final int numOfQuestions) {
        TEST_SET_SIZE = numOfQuestions;
       
        testQuestionSet = new ArrayList<Question_Abstract>() {{
                for (int i = 0; i < TEST_SET_SIZE; i++)
                add(fullQuestionSet.get(i));
        }};
        
        Collections.shuffle(testQuestionSet);
        return testQuestionSet;
    }
}
