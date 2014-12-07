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
public class FlashMath_ToBinaryTest {
    
    private FlashMath_ToBinary toBinary;
    
    @Before
    public void setUp() {
        toBinary = new FlashMath_ToBinary();
    }

    /**
     * Test of generateQuestion method, of class FlashMath_ToBinary.
     */
    @Test
    public void testGenerateQuestion() {
        toBinary.generateQuestion();
    }
    
}
