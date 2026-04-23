package org.howard.edu.lsp.finalexam.question3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GradeCalculatorTest {
    private final GradeCalculator calc = new GradeCalculator();

    // 1. Test average()
    @Test
    public void testAverageNormal() {
        assertEquals(80.0, calc.average(70, 80, 90), 0.001);
    }

    // 2. Test letterGrade()
    @Test
    public void testLetterGradeB() {
        assertEquals("B", calc.letterGrade(85.0));
    }

    // 3. Test isPassing()
    @Test
    public void testIsPassingTrue() {
        assertTrue(calc.isPassing(75.0));
    }

    // 4a. Boundary: exactly 60 (lowest passing grade)
    @Test
    public void testIsPassingBoundary60() {
        assertTrue(calc.isPassing(60.0));
        assertEquals("D", calc.letterGrade(60.0));
    }

    // 4b. Boundary: exactly 90 (boundary for A)
    @Test
    public void testLetterGradeBoundary90() {
        assertEquals("A", calc.letterGrade(90.0));
    }

    // 5a. Exception: score below 0
    @Test
    public void testAverageThrowsOnNegativeScore() {
        assertThrows(IllegalArgumentException.class,
            () -> calc.average(-1, 50, 50));
    }

    // 5b. Exception: score above 100
    @Test
    public void testAverageThrowsOnScoreOver100() {
        assertThrows(IllegalArgumentException.class,
            () -> calc.average(101, 50, 50));
    }
}