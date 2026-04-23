package org.howard.edu.lsp.assignment6;

import java.util.ArrayList;
import java.util.List;

public class IntegerSet {
    private List<Integer> set = new ArrayList<>();

    public IntegerSet() {}

    public void clear() { set.clear(); }

    public int length() { return set.size(); }

    public boolean equals(IntegerSet b) {
        return set.containsAll(b.set) && b.set.containsAll(set);
    }

    public boolean contains(int value) { return set.contains(value); }

    public int largest() throws IntegerSetException {
        if (set.isEmpty()) throw new IntegerSetException("Set is empty");
        int max = set.get(0);
        for (int n : set) if (n > max) max = n;
        return max;
    }

    public int smallest() throws IntegerSetException {
        if (set.isEmpty()) throw new IntegerSetException("Set is empty");
        int min = set.get(0);
        for (int n : set) if (n < min) min = n;
        return min;
    }

    public void add(int item) {
        if (!set.contains(item)) set.add(item);
    }

    public void remove(int item) { set.remove(Integer.valueOf(item)); }

    public void union(IntegerSet intSetb) {
        for (int n : intSetb.set)
            if (!set.contains(n)) set.add(n);
    }

    public void intersect(IntegerSet intSetb) {
        set.retainAll(intSetb.set);
    }

    public void diff(IntegerSet intSetb) {
        set.removeAll(intSetb.set);
    }

    public void complement(IntegerSet intSetb) {
        List<Integer> result = new ArrayList<>(intSetb.set);
        result.removeAll(set);
        set.clear();
        set.addAll(result);
    }

    public boolean isEmpty() { return set.isEmpty(); }

    public String toString() { return set.toString(); }
}