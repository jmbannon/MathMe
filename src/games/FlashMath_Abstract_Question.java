/*
 * MathMe is an educational program created by Jesse Bannon for 
 * TCSS 305 at University of Washington Tacoma (Fall Quarter 2014). 
 *
 * It is open source and can be modified, changed, and used in
 * any way so long as Jesse Bannon and MathMe is referenced.
 */
package games;

import class_resources.RandomVariable;
import java.text.DecimalFormat;

/**
 * @author Jesse Bannon
 * @version 1.0
 * 
 * Abstract subject type for random questions in the game Flash Math.
 */
public abstract class FlashMath_Abstract_Question {
    
    protected final RandomVariable randomVar; 
    private final FlashMath_Type type;
    private final DecimalFormat format;
    
    private String textQuestion;    
    private double answer;
    private String input;
    
   
    /**
     * Initializes values of the question to 0 or blank and sets the type of
     * question.
     * @param theType Question type.
     */
    public FlashMath_Abstract_Question(FlashMath_Type theType) {            
        randomVar = new RandomVariable();
        format = new DecimalFormat("#.###");
        type = theType;
        
        textQuestion = "";
        answer = 0;
        input = "";
    }
    
    /**
     * Code to be overridden in child classes to generate their question.
     */
    public void generateQuestion() { /* Override in child classes */ }
    
    /**
     * Sets the question to a text string.
     * @param question string of question.
     */
    public void setTextQuestion(final String question) {
        textQuestion = question;
    }
     
    /**
     * Sets the question answer.
     * @param theAnswer Question answer.
     */
    public void setAnswer(final double theAnswer) {
        answer = theAnswer;
    }
    
    /**
     * Sets the user Input.
     * @param userInput User input.
     */
    public void setInput(final String userInput) {
        input = userInput;
    }
    
    /**
     * Returns the question text.
     * @return question text string.
     */
    public String getQuestionText() {
        return textQuestion;
    }
    
    /**
     * Returns the answer.
     * @return The answer.
     */
    public double getAnswer() {
        return answer;
    }
    
    /**
     * Returns the user input.
     * @return User input.
     */
    public String getInput() {
        return input;
    }
    
    /**
     * Returns the text to display if the question is correct.
     * @return Correct answer display.
     */
    public String getDisplayCorrectAnswer() {
        return "<html><CENTER><FONT COLOR = GREEN>Correct!</FONT><br>" 
                + textQuestion + " = " + format.format(answer) 
                + "</CENTER></html>";
    }
    
    /**
     * Returns the text to display if the question is wrong.
     * @return Wrong answer display.
     */
    public String getDisplayWrongAnswer() {
        return "<html><CENTER><FONT COLOR = RED>Wrong!</FONT><br>" 
                + textQuestion + " = " + format.format(answer) 
                + "</CENTER></html>";
    }
    
    /**
     * Returns the text to display if the question was not answered.
     * @return No answer display.
     */
    public String getDisplayNoAnswer() {
        return "<html><CENTER><FONT COLOR = RED>Too Slow!</FONT><br>" 
                + textQuestion + " = " + format.format(answer) 
                + "</CENTER></html>";
    }
    
    /**
     * Returns the type of question.
     * @return Type of question.
     */
    public FlashMath_Type getType() {
        return type;
    }
    
    /**
     * Returns whether the user input is correct to the answer.
     * @return True if correct. False if incorrect.
     * @throws NumberFormatException 
     */
    public boolean isCorrect() {
        
        try {
            
        final String roundedAnswerString = format.format(answer);
        final double roundedAnswerDouble = Double.valueOf(roundedAnswerString);
        final double inputDouble = Double.valueOf(input);
        
        if (input.equals(roundedAnswerString) || inputDouble == answer 
                || inputDouble == roundedAnswerDouble)
            return true;
        
        else if (input.startsWith(".") && roundedAnswerString.startsWith("0."))
            return (input.substring(1).equals(roundedAnswerString.substring(2)));
        
        else if (input.startsWith("-.") && roundedAnswerString.startsWith("-0."))
            return (input.substring(2).equals(roundedAnswerString.substring(3)));
        
        else if (input.startsWith("0.") && roundedAnswerString.startsWith("0."))
            return (input.substring(2).equals(roundedAnswerString.substring(2)));
        
        else if (input.startsWith("-0.") && roundedAnswerString.startsWith("-0."))
            return (input.substring(3).equals(roundedAnswerString.substring(3)));
        else
            return false;
        
        } catch (NumberFormatException ex) {
            return false;
        }
    }   
}
