/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jesse
 */
public class FlashMath_ExponentTest {
    
    private FlashMath_Exponent exponent;
    
    @Before
    public void setUp() {
        exponent = new FlashMath_Exponent();
    }

    /**
     * Test of generateQuestion method, of class FlashMath_Exponent.
     */
    @Test
    public void testGenerateQuestion() {
        exponent.generateQuestion();
    }
    
}
