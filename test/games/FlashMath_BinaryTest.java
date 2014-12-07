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
public class FlashMath_BinaryTest {
    
    private FlashMath_Binary binary;
    
    @Before
    public void setUp() {
        binary = new FlashMath_Binary();
    }

    /**
     * Test of generateQuestion method, of class FlashMath_Binary.
     */
    @Test
    public void testGenerateQuestion() {
        binary.generateQuestion();
    }    
}
