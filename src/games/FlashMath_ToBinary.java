/*
 * MathMe is an educational program created by Jesse Bannon for 
 * TCSS 305 at University of Washington Tacoma (Fall Quarter 2014). 
 *
 * It is open source and can be modified, changed, and used in
 * any way so long as Jesse Bannon and MathMe is referenced.
 */
package games;

import static games.FlashMath_Type.TO_BINARY;

/**
 * @author Jesse Bannon
 * @version 1.0
 * 
 * Generates random to-binary questions for the game FlashMath.
 */
public class FlashMath_ToBinary extends FlashMath_Abstract_Question {
    
    /** Maximum range of generated question number. */
    private static final int MAXIMUM_RANGE = 64;
    
    /** Minimum range of generated question number. */
    private static final int MINIMUM_RANGE = 2;
    
    private int decimalValue;
    private int binaryInt;
    private String binaryString;
    
    /**
     * Sets the type of question to to-binary and generates the question.
     */
    public FlashMath_ToBinary() {
        super(TO_BINARY);
        generateQuestion();        
    }
    
    /**
     * Generates a random to-binary question.
     */
    @Override
    public final void generateQuestion() {
        decimalValue = randomVar.getInt(MINIMUM_RANGE, MAXIMUM_RANGE);
        binaryString = Integer.toBinaryString(decimalValue);
        binaryInt = Integer.valueOf(binaryString);        
        
        this.setTextQuestion(String.valueOf(decimalValue));
        this.setAnswer(binaryInt); 
    }       
}
