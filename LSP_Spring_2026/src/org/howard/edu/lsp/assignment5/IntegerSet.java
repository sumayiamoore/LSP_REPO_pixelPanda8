package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a mathematical set of integers.
 * A set cannot contain duplicate values.
 * Supports standard set operations: union, intersection, difference, and complement.
 *
 * <p>All set operations return a new {@code IntegerSet} and do not modify the original sets.</p>
 *
 * @author Student
 * @version 1.0
 */
public class IntegerSet {

    /** Internal list storing the unique integer elements of this set. */
    private ArrayList<Integer> set = new ArrayList<>();

    /**
     * Constructs an empty IntegerSet.
     */
    public IntegerSet() {
    }

    /**
     * Removes all elements from this set.
     * After calling this method, the set will be empty.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements in this set.
     *
     * @return the number of elements in this set
     */
    public int length() {
        return set.size();
    }

    /**
     * Returns {@code true} if this set contains the same elements as the specified set,
     * regardless of order.
     *
     * @param b the IntegerSet to compare with
     * @return {@code true} if both sets contain exactly the same elements; {@code false} otherwise
     */
    public boolean equals(IntegerSet b) {
        ArrayList<Integer> copyA = new ArrayList<>(this.set);
        ArrayList<Integer> copyB = new ArrayList<>(b.set);
        Collections.sort(copyA);
        Collections.sort(copyB);
        return copyA.equals(copyB);
    }

    /**
     * Returns {@code true} if this set contains the specified value.
     *
     * @param value the integer value to check for
     * @return {@code true} if the value is in the set; {@code false} otherwise
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest element in this set.
     *
     * @return the largest integer in this set
     * @throws IllegalStateException if the set is empty
     */
    public int largest() {
        if (set.isEmpty()) {
            throw new IllegalStateException("Set is empty");
        }
        return Collections.max(set);
    }

    /**
     * Returns the smallest element in this set.
     *
     * @return the smallest integer in this set
     * @throws IllegalStateException if the set is empty
     */
    public int smallest() {
        if (set.isEmpty()) {
            throw new IllegalStateException("Set is empty");
        }
        return Collections.min(set);
    }

    /**
     * Adds the specified item to this set if it is not already present.
     * Duplicates are ignored.
     *
     * @param item the integer to add to this set
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes the specified item from this set if it is present.
     * If the item is not in the set, the set is unchanged.
     *
     * @param item the integer to remove from this set
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Returns a new IntegerSet containing all elements that appear in either this set
     * or the specified set (or both).
     *
     * <p>Example: {1, 2, 3} union {2, 3, 4} = {1, 2, 3, 4}</p>
     *
     * @param intSetb the other IntegerSet to union with
     * @return a new IntegerSet representing the union of the two sets
     */
    public IntegerSet union(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        result.set.addAll(this.set);
        for (int item : intSetb.set) {
            if (!result.set.contains(item)) {
                result.set.add(item);
            }
        }
        return result;
    }

    /**
     * Returns a new IntegerSet containing only the elements common to both this set
     * and the specified set.
     *
     * <p>Example: {1, 2, 3} intersect {2, 3, 4} = {2, 3}</p>
     *
     * @param intSetb the other IntegerSet to intersect with
     * @return a new IntegerSet representing the intersection of the two sets
     */
    public IntegerSet intersect(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        result.set.addAll(this.set);
        result.set.retainAll(intSetb.set);
        return result;
    }

    /**
     * Returns a new IntegerSet containing elements that are in this set but not in
     * the specified set.
     *
     * <p>Example: {1, 2, 3} diff {2, 3, 4} = {1}</p>
     *
     * @param intSetb the set to subtract from this set
     * @return a new IntegerSet representing the difference (this set minus intSetb)
     */
    public IntegerSet diff(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        result.set.addAll(this.set);
        result.set.removeAll(intSetb.set);
        return result;
    }

    /**
     * Returns a new IntegerSet containing elements that are in the specified set but
     * not in this set. This is equivalent to {@code intSetb.diff(this)}.
     *
     * <p>Example: {1, 2, 3} complement {2, 3, 4} = {4}</p>
     *
     * @param intSetb the set to compare against
     * @return a new IntegerSet containing elements in intSetb that are not in this set
     */
    public IntegerSet complement(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        result.set.addAll(intSetb.set);
        result.set.removeAll(this.set);
        return result;
    }

    /**
     * Returns {@code true} if this set contains no elements.
     *
     * @return {@code true} if this set is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of this set in ascending order.
     *
     * <p>Format: {@code [1, 2, 3]} — values separated by a comma and a single space,
     * enclosed in square brackets. An empty set returns {@code []}.</p>
     *
     * @return a string representation of this set
     */
    @Override
    public String toString() {
        ArrayList<Integer> sorted = new ArrayList<>(set);
        Collections.sort(sorted);
        return sorted.toString();
    }
}