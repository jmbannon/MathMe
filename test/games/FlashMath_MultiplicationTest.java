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
public class FlashMath_MultiplicationTest {
    
    private FlashMath_Multiplication multiplication;
    
    @Before
    public void setUp() {
        multiplication = new FlashMath_Multiplication();
    }

    /**
     * Test of generateQuestion method, of class FlashMath_Multiplication.
     */
    @Test
    public void testGenerateQuestion() {
        multiplication.generateQuestion();
    }
    
}
