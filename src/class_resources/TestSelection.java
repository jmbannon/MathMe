/*
 * MathMe is an educational program created by Jesse Bannon for 
 * TCSS 305 at University of Washington Tacoma (Fall Quarter 2014). 
 *
 * It is open source and can be modified, changed, and used in
 * any way so long as Jesse Bannon and MathMe is referenced.
 */
package class_resources;

/**
 * @author Jesse Bannon
 * @version 1.0
 * 
 * Contains all series and subjects when selecting a test.
 */
public class TestSelection {
    
    /** Series available to test on */
    private static final String[] SERIES = new String[] { "Select...", 
        "Elementary", "Pre-Algebra", "Algebra", "Geometry", 
        "Algebra II", "Pre-Calculus", "Calculus I", "Calculus II", 
        "Calculus III", "Diff. Equations", "Linear Algebra" };
    
    /** Subjects if Series is not selected */
    private static final String[] NOTHING_SELECTED = new String[] {
        "Select Series..." };
    
    /** Subjects of Elementary Series */
    private static final String[] ELEMENTARY_SUBJECTS = new String[] {
        "Arithmetic", "Multiplication", "Division", 
        "Factors", "Fractions", "Decimals", "Geometry" };
    
    /** Subjects of Pre-Algebra Series */
    private static final String[] PRE_ALGEBRA_SUBJECTS = new String[] { 
        "Order of Operations", "Absolute Value", 
        "Solving Equations", "Graphs" };
    
    /** Subjects of Algebra Series */
    private static final String[] ALGEBRA_SUBJECTS = new String[] {
        "Functions", "Linear Equations", "Polynomials", 
        "Factoring", "Square Roots" };
    
    /** Subjects of Geometry Series */
    private static final String[] GEOMETRY_SUBJECTS = new String[] {
        "Basic Shapes", "Angles", "Polygons", "3d Objects" };
    
    /** Subjects of Algebra II Series */
    private static final String[] ALGEBRA_II_SUBJECTS = new String[] {
        "Not yet implemented"
    };
    
    /** Subjects of Pre-Calculus Series */
    private static final String[] PRE_CALCULUS_SUBJECTS = new String[] {
        "Not yet implemented"
    };
    
    /** Subjects of Calculus I Series */
    private static final String[] CALCULUS_I_SUBJECTS = new String[] {
        "Not yet implemented"
    };
    
    /** Subjects of Calculus II Series */
    private static final String[] CALCULUS_II_SUBJECTS = new String[] {
        "Not yet implemented"
    };
    
    /** Subjects of Calculus III Series */
    private static final String[] CALCULUS_III_SUBJECTS = new String[] {
        "Not yet implemented"
    };
    
    /** Subjects of Differential Equations Series */
    private static final String[] DIFF_EQUATIONS_SUBJECTS = new String[] {
        "Not yet implemented"
    };
    
    /** Subjects of Linear Algebra Series */
    private static final String[] LINEAR_ALGEBRA_SUBJECTS = new String[] {
        "Not yet implemented"
    };
    
    /** Array of Subject arrays. */
    private static final String[][] SUBJECTS = new String[][] { 
        NOTHING_SELECTED, ELEMENTARY_SUBJECTS, PRE_ALGEBRA_SUBJECTS, 
        ALGEBRA_SUBJECTS, GEOMETRY_SUBJECTS, ALGEBRA_II_SUBJECTS,
        PRE_CALCULUS_SUBJECTS, CALCULUS_I_SUBJECTS, CALCULUS_II_SUBJECTS,
        CALCULUS_III_SUBJECTS, DIFF_EQUATIONS_SUBJECTS, LINEAR_ALGEBRA_SUBJECTS 
    };
    
    /**
     * Does nothing. Do not use.
     */
    private TestSelection() { /* Do nothing */ }
    
    /**
     * Returns array of Series.
     * @return Array of Series.
     */
    public static String[] getSeries() {
        return SERIES;
    }
    
    /**
     * Returns array of subjects based on series selection.
     * @param seriesIndex Index of array SERIES.
     * @return Array of subjects based on selection.
     */
    public static String[] getSubjects(final int seriesIndex)
            throws IllegalArgumentException {
        
        if (seriesIndex > SUBJECTS.length) 
            throw new IllegalArgumentException("seriesIndex out of bounds");
        return SUBJECTS[seriesIndex];
    }
    
    /**
     * Returns the specific subject from a series.
     * @param seriesIndex Index of array SERIES.
     * @param subjectIndex Index of specified subject array.
     * @return Name of subject from subject array.
     * @throws IllegalArgumentException Out of bounds for either array.
     */
    public static String getSubject(final int seriesIndex, 
            final int subjectIndex) throws IllegalArgumentException { 
        
        if (seriesIndex > SUBJECTS.length) 
            throw new IllegalArgumentException("seriesIndex out of bounds");
        
        else if (subjectIndex > SUBJECTS[seriesIndex].length)
            throw new IllegalArgumentException("subjectIndex out of bounds");
        
        else
            return SUBJECTS[seriesIndex][subjectIndex];
    }
}
