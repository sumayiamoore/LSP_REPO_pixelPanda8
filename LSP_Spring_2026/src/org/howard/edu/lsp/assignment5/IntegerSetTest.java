package org.howard.edu.lsp.assignment5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegerSetTest {

    @Test
    public void testClear() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.clear();
        assertTrue(set.isEmpty());
    }

    @Test
    public void testLengthEmpty() {
        IntegerSet set = new IntegerSet();
        assertEquals(0, set.length());
    }

    @Test
    public void testLengthNonEmpty() {
        IntegerSet set = new IntegerSet();
        set.add(1); set.add(2); set.add(3);
        assertEquals(3, set.length());
    }

    @Test
    public void testEqualsSameOrder() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1); set1.add(2); set1.add(3);
        IntegerSet set2 = new IntegerSet();
        set2.add(1); set2.add(2); set2.add(3);
        assertTrue(set1.equals(set2));
    }

    @Test
    public void testEqualsDifferentOrder() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1); set1.add(2); set1.add(3);
        IntegerSet set2 = new IntegerSet();
        set2.add(3); set2.add(2); set2.add(1);
        assertTrue(set1.equals(set2));
    }

    @Test
    public void testNotEquals() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1); set1.add(2);
        IntegerSet set2 = new IntegerSet();
        set2.add(1); set2.add(3);
        assertFalse(set1.equals(set2));
    }

    @Test
    public void testContainsTrue() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        assertTrue(set.contains(5));
    }

    @Test
    public void testContainsFalse() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        assertFalse(set.contains(10));
    }

    @Test
    public void testLargest() {
        IntegerSet set = new IntegerSet();
        set.add(1); set.add(5); set.add(3);
        assertEquals(5, set.largest());
    }

    @Test
    public void testLargestEmptySet() {
        IntegerSet set = new IntegerSet();
        assertThrows(IllegalStateException.class, () -> set.largest());
    }

    @Test
    public void testSmallest() {
        IntegerSet set = new IntegerSet();
        set.add(1); set.add(5); set.add(3);
        assertEquals(1, set.smallest());
    }

    @Test
    public void testSmallestEmptySet() {
        IntegerSet set = new IntegerSet();
        assertThrows(IllegalStateException.class, () -> set.smallest());
    }

    @Test
    public void testAdd() {
        IntegerSet set = new IntegerSet();
        set.add(10);
        assertEquals(1, set.length());
        assertTrue(set.contains(10));
    }

    @Test
    public void testAddDuplicate() {
        IntegerSet set = new IntegerSet();
        set.add(10);
        set.add(10);
        assertEquals(1, set.length());
    }

    @Test
    public void testRemove() {
        IntegerSet set = new IntegerSet();
        set.add(1); set.add(2);
        set.remove(1);
        assertFalse(set.contains(1));
        assertEquals(1, set.length());
    }

    @Test
    public void testRemoveNotPresent() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.remove(99);
        assertEquals(1, set.length());
    }

    @Test
    public void testUnion() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1); set1.add(2); set1.add(3);
        IntegerSet set2 = new IntegerSet();
        set2.add(2); set2.add(3); set2.add(4);
        IntegerSet result = set1.union(set2);
        assertTrue(result.contains(1));
        assertTrue(result.contains(2));
        assertTrue(result.contains(3));
        assertTrue(result.contains(4));
        assertEquals(4, result.length());
    }

    @Test
    public void testUnionDoesNotModifyOriginals() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1); set1.add(2);
        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set1.union(set2);
        assertEquals(2, set1.length());
        assertEquals(1, set2.length());
    }

    @Test
    public void testIntersect() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1); set1.add(2); set1.add(3);
        IntegerSet set2 = new IntegerSet();
        set2.add(2); set2.add(3); set2.add(4);
        IntegerSet result = set1.intersect(set2);
        assertTrue(result.contains(2));
        assertTrue(result.contains(3));
        assertEquals(2, result.length());
    }

    @Test
    public void testIntersectNoCommon() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1); set1.add(2);
        IntegerSet set2 = new IntegerSet();
        set2.add(3); set2.add(4);
        IntegerSet result = set1.intersect(set2);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testDiff() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1); set1.add(2); set1.add(3);
        IntegerSet set2 = new IntegerSet();
        set2.add(2); set2.add(3); set2.add(4);
        IntegerSet result = set1.diff(set2);
        assertTrue(result.contains(1));
        assertEquals(1, result.length());
    }

    @Test
    public void testDiffDoesNotModifyOriginals() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1); set1.add(2);
        IntegerSet set2 = new IntegerSet();
        set2.add(2);
        set1.diff(set2);
        assertEquals(2, set1.length());
    }

    @Test
    public void testComplement() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1); set1.add(2); set1.add(3);
        IntegerSet set2 = new IntegerSet();
        set2.add(2); set2.add(3); set2.add(4);
        IntegerSet result = set1.complement(set2);
        assertTrue(result.contains(4));
        assertEquals(1, result.length());
    }

    @Test
    public void testIsEmptyTrue() {
        IntegerSet set = new IntegerSet();
        assertTrue(set.isEmpty());
    }

    @Test
    public void testIsEmptyFalse() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        assertFalse(set.isEmpty());
    }

    @Test
    public void testToString() {
        IntegerSet set = new IntegerSet();
        set.add(3); set.add(1); set.add(2);
        assertEquals("[1, 2, 3]", set.toString());
    }

    @Test
    public void testToStringEmpty() {
        IntegerSet set = new IntegerSet();
        assertEquals("[]", set.toString());
    }
}