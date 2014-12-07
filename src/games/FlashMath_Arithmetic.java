/*
 * MathMe is an educational program created by Jesse Bannon for 
 * TCSS 305 at University of Washington Tacoma (Fall Quarter 2014). 
 *
 * It is open source and can be modified, changed, and used in
 * any way so long as Jesse Bannon and MathMe is referenced.
 */
package games;

import static games.FlashMath_Type.ARITHMETIC;

/**
 * @author Jesse Bannon
 * @version 1.0
 * 
 * Generates random arithmetic questions for the game FlashMath.
 */
public class FlashMath_Arithmetic extends FlashMath_Abstract_Question {
    
    /** Maximum range of generated question number. */
    private static final int MAXIMUM_RANGE = 50;
    
    /** Minimum range of generated question number */
    private static final int MINIMUM_RANGE = 8;
    
    private int randomNumberOne;
    private int randomNumberTwo;

    /**
     * Sets the type of question to arithmetic and generates the question.
     */
    public FlashMath_Arithmetic() {
        super(ARITHMETIC);
        generateQuestion();        
    }
    
    /**
     * Generates an arithmetic question.
     */
    @Override
    public final void generateQuestion() {        
        final StringBuilder questionBuilder = new StringBuilder();
        randomNumberOne = randomVar.getInt(MINIMUM_RANGE, MAXIMUM_RANGE);
        randomNumberTwo = randomVar.getInt(MINIMUM_RANGE, MAXIMUM_RANGE);
        
        if (randomVar.getBoolean()) {
            randomNumberOne *= -1;
            if (randomVar.getBoolean())
                randomNumberTwo *= -1;
        }
        
        if (randomVar.getBoolean()) {
            questionBuilder.append(randomNumberOne);
            questionBuilder.append(" + ");
            questionBuilder.append(randomNumberTwo);
            this.setTextQuestion(questionBuilder.toString());
            
            final int sum = randomNumberOne + randomNumberTwo;
            this.setAnswer(sum); 
            
        } else  {
            questionBuilder.append(randomNumberOne);
            questionBuilder.append(" - ");
            questionBuilder.append(randomNumberTwo);
            this.setTextQuestion(questionBuilder.toString());
            
            final int sum = randomNumberOne - randomNumberTwo;
            this.setAnswer(sum);
        }        
    }        
}
