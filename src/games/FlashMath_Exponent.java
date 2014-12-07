/*
 * MathMe is an educational program created by Jesse Bannon for 
 * TCSS 305 at University of Washington Tacoma (Fall Quarter 2014). 
 *
 * It is open source and can be modified, changed, and used in
 * any way so long as Jesse Bannon and MathMe is referenced.
 */
package games;

import static games.FlashMath_Type.EXPONENT;

/**
 * @author Jesse Bannon
 * @version 1.0
 * 
 * Generates random exponent questions for the game FlashMath.
 */
public class FlashMath_Exponent extends FlashMath_Abstract_Question {
    
    /** Maximum range of exponent base. */
    private static final int BASE_MIN_RANGE = 2;
    
    /** Minimum range of exponent base. */
    private static final int BASE_MAX_RANGE = 8;
    
    /** Exponent range 2. */
    private static final int EXPONENT_2 = 2;
    
    /** Exponent range 3. */
    private static final int EXPONENT_3 = 3;
    
    /** Exponent range 4. */
    private static final int EXPONENT_4 = 4;
    
    /** Exponent range 8. */
    private static final int EXPONENT_8 = 8;
    
    /** Exponent range -1. */
    private static final int EXPONENT_NEG_1 = -1;
    
    /** Exponent range -4. */
    private static final int EXPONENT_NEG_4 = -4;
    
    private int base;
    private int exponent;
    private double sum;
    
    /**
     * Sets the type of question to exponent and generates the question.
     */
    public FlashMath_Exponent() {
        super(EXPONENT);
        generateQuestion();        
    }
    
    /**
     * Generates an exponent question.
     */
    @Override
    public final void generateQuestion() {
        final StringBuilder questionBuilder = new StringBuilder();
        base = randomVar.getInt(BASE_MIN_RANGE, BASE_MAX_RANGE);
        
        
        if (base == 2 || base  == 4)
            if (randomVar.getBoolean())
                if (base == 2)
                    exponent = randomVar.getInt(EXPONENT_2, EXPONENT_8);
                else
                    exponent = randomVar.getInt(EXPONENT_2, EXPONENT_4);
            else
                exponent = randomVar.getInt(EXPONENT_NEG_1, EXPONENT_NEG_4);
            

        else
            // Either base^2, base^3, or base^-1
            if (randomVar.getBoolean())
                exponent = randomVar.getInt(EXPONENT_2, EXPONENT_3);
            else
                exponent = EXPONENT_NEG_1;
            
        
        final double product = calculateExponent(base, exponent);
        this.setAnswer(product); 
            
        questionBuilder.append(base);
        questionBuilder.append("^");
        questionBuilder.append(exponent);
        
        this.setTextQuestion(questionBuilder.toString());
    }
    
    private double calculateExponent(final int base, final int exponent) {
        sum = 1;
        if (exponent > 0) 
            for (int i = 0; i < exponent; ++i)
                sum *= base;
        else if (exponent < 0)
            for (int i = 0; i > exponent; --i)
                sum /= base;
        else
            return 1;
        return sum;
    }
}
