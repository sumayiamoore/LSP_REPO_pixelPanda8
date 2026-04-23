package org.howard.edu.lsp.assignment6;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class IntegerSetTest {

    private IntegerSet set1;
    private IntegerSet set2;

    @BeforeEach
    public void setUp() {
        set1 = new IntegerSet();
        set2 = new IntegerSet();
    }

    // ---- clear() ----
    @Test
    public void testClearNormal() {
        set1.add(1); set1.add(2);
        set1.clear();
        assertEquals(0, set1.length());
    }

    @Test
    public void testClearEdge_alreadyEmpty() {
        set1.clear(); // should not throw
        assertTrue(set1.isEmpty());
    }

    // ---- length() ----
    @Test
    public void testLengthNormal() {
        set1.add(10); set1.add(20);
        assertEquals(2, set1.length());
    }

    @Test
    public void testLengthEdge_emptySet() {
        assertEquals(0, set1.length());
    }

    // ---- equals() ----
    @Test
    public void testEqualsNormal_sameElementsDifferentOrder() {
        set1.add(1); set1.add(2); set1.add(3);
        set2.add(3); set2.add(1); set2.add(2);
        assertTrue(set1.equals(set2));
    }

    @Test
    public void testEqualsEdge_mismatch() {
        set1.add(1); set1.add(2);
        set2.add(1); set2.add(3);
        assertFalse(set1.equals(set2));
    }

    // ---- contains() ----
    @Test
    public void testContainsNormal_present() {
        set1.add(5);
        assertTrue(set1.contains(5));
    }

    @Test
    public void testContainsEdge_notPresent() {
        set1.add(5);
        assertFalse(set1.contains(99));
    }

    // ---- largest() ----
    @Test
    public void testLargestNormal() throws IntegerSetException {
        set1.add(3); set1.add(7); set1.add(1);
        assertEquals(7, set1.largest());
    }

    @Test
    public void testLargestEdge_singleElement() throws IntegerSetException {
        set1.add(42);
        assertEquals(42, set1.largest());
    }

    @Test
    public void testLargestEdge_emptyThrows() {
        assertThrows(IntegerSetException.class, () -> set1.largest());
    }

    // ---- smallest() ----
    @Test
    public void testSmallestNormal() throws IntegerSetException {
        set1.add(3); set1.add(7); set1.add(1);
        assertEquals(1, set1.smallest());
    }

    @Test
    public void testSmallestEdge_singleElement() throws IntegerSetException {
        set1.add(42);
        assertEquals(42, set1.smallest());
    }

    @Test
    public void testSmallestEdge_emptyThrows() {
        assertThrows(IntegerSetException.class, () -> set1.smallest());
    }

    // ---- add() ----
    @Test
    public void testAddNormal() {
        set1.add(10);
        assertTrue(set1.contains(10));
        assertEquals(1, set1.length());
    }

    @Test
    public void testAddEdge_duplicate() {
        set1.add(5); set1.add(5);
        assertEquals(1, set1.length()); // no duplicates allowed
    }

    // ---- remove() ----
    @Test
    public void testRemoveNormal() {
        set1.add(4);
        set1.remove(4);
        assertFalse(set1.contains(4));
    }

    @Test
    public void testRemoveEdge_valueNotPresent() {
        set1.add(4);
        set1.remove(99); // should not throw
        assertEquals(1, set1.length());
    }

    // ---- union() ----
    @Test
    public void testUnionNormal() {
        set1.add(1); set1.add(2);
        set2.add(3); set2.add(4);
        set1.union(set2);
        assertTrue(set1.contains(1) && set1.contains(2)
                && set1.contains(3) && set1.contains(4));
    }

    @Test
    public void testUnionEdge_withEmptySet() {
        set1.add(1); set1.add(2);
        set1.union(set2); // set2 is empty
        assertEquals(2, set1.length());
    }

    // ---- intersect() ----
    @Test
    public void testIntersectNormal() {
        set1.add(1); set1.add(2); set1.add(3);
        set2.add(2); set2.add(3); set2.add(4);
        set1.intersect(set2);
        assertTrue(set1.contains(2) && set1.contains(3));
        assertEquals(2, set1.length());
    }

    @Test
    public void testIntersectEdge_noCommonElements() {
        set1.add(1); set1.add(2);
        set2.add(3); set2.add(4);
        set1.intersect(set2);
        assertTrue(set1.isEmpty());
    }

    // ---- diff() ----
    @Test
    public void testDiffNormal() {
        set1.add(1); set1.add(2); set1.add(3);
        set2.add(2);
        set1.diff(set2);
        assertTrue(set1.contains(1) && set1.contains(3));
        assertFalse(set1.contains(2));
    }

    @Test
    public void testDiffEdge_identicalSets() {
        set1.add(1); set1.add(2);
        set2.add(1); set2.add(2);
        set1.diff(set2);
        assertTrue(set1.isEmpty());
    }

    // ---- complement() ----
    @Test
    public void testComplementNormal() {
        set1.add(1); set1.add(2);
        set2.add(1); set2.add(2); set2.add(3); set2.add(4);
        set1.complement(set2);
        assertTrue(set1.contains(3) && set1.contains(4));
        assertEquals(2, set1.length());
    }

    @Test
    public void testComplementEdge_disjointSets() {
        set1.add(1); set1.add(2);
        set2.add(3); set2.add(4);
        set1.complement(set2);
        // complement of set1 in set2 = all of set2 (since they're disjoint)
        assertTrue(set1.contains(3) && set1.contains(4));
    }

    // ---- isEmpty() ----
    @Test
    public void testIsEmptyEdge_empty() {
        assertTrue(set1.isEmpty());
    }

    @Test
    public void testIsEmptyNormal_nonEmpty() {
        set1.add(1);
        assertFalse(set1.isEmpty());
    }

    // ---- toString() ----
    @Test
    public void testToStringNormal() {
        set1.add(1); set1.add(2); set1.add(3);
        assertEquals("[1, 2, 3]", set1.toString());
    }

    @Test
    public void testToStringEdge_emptySet() {
        assertEquals("[]", set1.toString());
    }
}