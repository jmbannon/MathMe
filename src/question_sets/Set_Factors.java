/*
 * MathMe is an educational program created by Jesse Bannon for 
 * TCSS 305 at University of Washington Tacoma (Fall Quarter 2014). 
 *
 * It is open source and can be modified, changed, and used in
 * any way so long as Jesse Bannon and MathMe is referenced.
 */
package question_sets;

import question.Question_CheckBox;
import question.Question_MultipleChoice;
import question.Question_TextBox;
import question.Question_TrueFalse;

/**
 * @author Jesse Bannon
 * @version 1.0
 * 
 * Factors question set for MathMe tests.
 */
public final class Set_Factors extends Set_Abstract {
    
    /**
     * Sets test name to Factors and fills questions.
     */
    public Set_Factors() {
        super("Factors");
        fillQuestions();        
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected void fillQuestions() {
        
        Question_MultipleChoice q1 = new Question_MultipleChoice();
        q1.setImageQuestion("FACTORS_AntGraph.jpg");
        q1.setAnswer(
            "constant speed; 2 cm/s", 
            "constant speed; 5 cm/s", 
            "constant speed; 10 cm/s", 
            "variable speed", 2);
        fullQuestionSet.add(q1);
        
        Question_TrueFalse q2 = new Question_TrueFalse();
        q2.setTextQuestion("7 is a factor of 84.");
        q2.setAnswer(true);
        fullQuestionSet.add(q2);
        
        Question_MultipleChoice q3 = new Question_MultipleChoice();
        q3.setTextQuestion("24 is divisible by");
        q3.setAnswer(
            "1, 2, 5, and 12", 
            "4, 6, and 8", 
            "48", 
            "2, 3, 4, and 7", 2);
        fullQuestionSet.add(q3);
        
        Question_TrueFalse q4 = new Question_TrueFalse();        
        q4.setTextQuestion("9 is a factor of 315.");
        q4.setAnswer(true);
        fullQuestionSet.add(q4);
        
        Question_TextBox q5 = new Question_TextBox();
        q5.setTextQuestion("Round 3.674 to one decimal place.");
        q5.setAnswer("3.7");
        fullQuestionSet.add(q5);
        
        Question_CheckBox q6 = new Question_CheckBox();
        q6.setTextQuestion("Check all numbers divisible by 32.");
        q6.setAnswer("16", true, "6", false, "8", true, "4", true);
        fullQuestionSet.add(q6);
        
        Question_MultipleChoice q7 = new Question_MultipleChoice();
        q7.setTextQuestion("35 / 5 = ?");
        q7.setAnswer("5", "6", "7", "8", 3);
        fullQuestionSet.add(q7);
        
        Question_MultipleChoice q8 = new Question_MultipleChoice();
        q8.setTextQuestion("What is the greatest common factor (GCF) of 40 and 26?");
        q8.setAnswer("2", "4", "8", "13", 1);
        fullQuestionSet.add(q8);
        
        Question_TrueFalse q9 = new Question_TrueFalse();
        q9.setTextQuestion("8 is a factor of 522.");
        q9.setAnswer(false);
        fullQuestionSet.add(q9);
        
        Question_CheckBox q10 = new Question_CheckBox();
        q10.setTextQuestion("Check all numbers divisible by 100.");
        q10.setAnswer("25", true, "8", false, "15", false, "5", true);
        fullQuestionSet.add(q10);
        
        Question_CheckBox q11 = new Question_CheckBox();
        q11.setTextQuestion("Check all numbers that are factors of both 45 and 20.");
        q11.setAnswer("3", false, "4", false, "5", true, "6", false);
        fullQuestionSet.add(q11);
        
        Question_MultipleChoice q12 = new Question_MultipleChoice();
        q12.setTextQuestion("What is the prime factorization of 72?");
        q12.setAnswer("2*2*2*2*3", "2*2*2*3*3", "2*2*3*3*3", "2*2*2*2*2", 2);
        fullQuestionSet.add(q12);
        
        Question_MultipleChoice q13 = new Question_MultipleChoice();
        q13.setTextQuestion("What is the prime factorization of 81?");
        q13.setAnswer("2*3*3*3", "2*2*2*3", "2*2*3*3*3", "3*3*3*3", 4);
        fullQuestionSet.add(q13);
    }
}
