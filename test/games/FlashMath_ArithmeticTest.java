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
public class FlashMath_ArithmeticTest {
    
    private FlashMath_Arithmetic arithmetic;
    
    @Before
    public void setUp() {
        arithmetic = new FlashMath_Arithmetic();
    }

    /**
     * Test of generateQuestion method, of class FlashMath_Arithmetic.
     */
    @Test
    public void testGenerateQuestion() {
        arithmetic.generateQuestion();
    }
    
}
