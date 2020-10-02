package com.nalmoussa.coding.practice.problem036;

import java.util.Comparator;

// This is used by the priority queue to compare the areas of two shapes
public class AreaComparator implements Comparator<Object> {
    @Override
    public int compare(Object o1, Object o2) {
        Shape s1 = (Shape)o1;
        Shape s2 = (Shape)o2;
        return Double.compare(s2.getArea(), s1.getArea());
    }
}
