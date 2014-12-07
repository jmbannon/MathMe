/*
 * MathMe is an educational program created by Jesse Bannon for 
 * TCSS 305 at University of Washington Tacoma (Fall Quarter 2014). 
 *
 * It is open source and can be modified, changed, and used in
 * any way so long as Jesse Bannon and MathMe is referenced.
 */
package games;

import static games.FlashMath_Type.MULTIPLICATION;

/**
 * @author Jesse Bannon
 * @version 1.0
 * 
 * Generates random multiplication questions for the game FlashMath.
 */
public class FlashMath_Multiplication extends FlashMath_Abstract_Question {
    
    /** Maximum range of generated question number. */
    private static final int MAXIMUM_RANGE = 15;
    
    /** Minimum range of generated question number. */
    private static final int MINIMUM_RANGE = 2;
    
    private int randomNumberOne;
    private int randomNumberTwo;
    
    /**
     * Sets the type of question to multiplication and generates the question.
     */
    public FlashMath_Multiplication() {
        super(MULTIPLICATION);
        generateQuestion();        
    }
    
    /**
     * Generates a random multiplication question.
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
            
        
        questionBuilder.append(randomNumberOne);
        questionBuilder.append(" * ");
        questionBuilder.append(randomNumberTwo);
        this.setTextQuestion(questionBuilder.toString());
            
        final int product = randomNumberOne * randomNumberTwo;
        this.setAnswer(product); 
    }       
}
