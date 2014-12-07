/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package class_resources;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jesse
 */
public class RandomVariableTest {
    
    RandomVariable randomVariable;
    
    @Before
    public void setUp() {
        randomVariable = new RandomVariable();
    }

    /**
     * Test of getInt method, of class RandomVariable.
     */
    @Test
    public void testGetInt() {
        randomVariable.getInt(-30, -1);
        randomVariable.getInt(-30, 30);
        randomVariable.getInt(30, 60);
        randomVariable.getInt(0, 0);
        randomVariable.getInt(20, 20);
    }
    
    /**
     * Test of getInt method, of class RandomVariable.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testGetBadInt() {
        randomVariable.getInt(30, -1);
    }

    /**
     * Test of getBoolean method, of class RandomVariable.
     */
    @Test
    public void testGetBoolean() {
        randomVariable.getBoolean();
    }
    
}
