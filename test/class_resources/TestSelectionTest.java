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
public class TestSelectionTest {
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getSeries method, of class TestSelection.
     */
    @Test
    public void testGetSeries() {
        TestSelection.getSeries();
    }

    /**
     * Test of getSubjects method, of class TestSelection.
     */
    @Test
    public void testGetSubjects() {
        TestSelection.getSubjects(2);
    }
    
    /**
     * Test of getSubjects method, of class TestSelection.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testGetBadSubjects() {
        TestSelection.getSubjects(9001);
    }

    /**
     * Test of getSubject method, of class TestSelection.
     */
    @Test
    public void testGetSubject() {
        TestSelection.getSubject(2, 3);
    }
    
    /**
     * Test of getSubject method, of class TestSelection.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testGetBadSubjectSeriesIndex() {
        TestSelection.getSubject(9001, 2);
    }
    
    /**
     * Test of getSubject method, of class TestSelection.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testGetBadSubjectSubjectIndex() {
        TestSelection.getSubject(2, 9001);
    }
    
}
