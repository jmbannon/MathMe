/*
 * MathMe is an educational program created by Jesse Bannon for 
 * TCSS 305 at University of Washington Tacoma (Fall Quarter 2014). 
 *
 * It is open source and can be modified, changed, and used in
 * any way so long as Jesse Bannon and MathMe is referenced.
 */
package class_resources;

import java.util.Random;

/**
 * @author Jesse Bannon
 * @version 1.0
 * 
 * Creates a random variable of specified range.
 */
public class RandomVariable {
    private final Random random;
    
    private int minRange;
    private int maxRange;
    private int randomInt;
    
    /**
     * Initializes the random type.
     */
    public RandomVariable() {
        random = new Random();
    }
    
    /**
     * Returns a random integer of the specified range.
     * @param minimumRange Minimum range of random integer.
     * @param maximumRange Maximum range of random integer.
     * @return Random integer.
     * @throws IllegalArgumentException If maximumRange is greater than minimum 
     * range.
     */
    public int getInt(final int minimumRange, final int maximumRange) 
            throws IllegalArgumentException {
        if (minimumRange > maximumRange)
            throw new IllegalArgumentException("ERROR: Maximum Range is "
                    + "greater than Minimum Range"); 
        
        else if (minimumRange == maximumRange)
            return minimumRange;
        
        else if (minimumRange >= 0 && maximumRange > 0) {
            minRange = minimumRange;
            maxRange = maximumRange;
            randomInt = random.nextInt(maxRange - minRange + 1) + minRange;
            return randomInt;
        } 
        
        else if (minimumRange < 0 && maximumRange <= 0) {
            minRange = -maximumRange;
            maxRange = -minimumRange;
            randomInt = random.nextInt(maxRange - minRange + 1) + minRange;
            randomInt = -randomInt;
            return randomInt;
        } 
        
        else if (minimumRange < 0 && maximumRange >= 0) {
            if (getBoolean()) {
                minRange = 0;
                maxRange = -minimumRange;
                randomInt = random.nextInt(maxRange - minRange + 1) + minRange;
                randomInt = -randomInt;
                return randomInt;
            }
            else {
                minRange = 0;
                maxRange = maximumRange;
                randomInt = random.nextInt(maxRange - minRange + 1) + minRange;
                return randomInt;
            }
        } 
        
        else {
            throw new IllegalArgumentException("ERROR: Maximum Range is "
                    + "greater than Minimum Range");          
        }         
    }
    
    public boolean getBoolean() {
        return random.nextBoolean();
    }
}
