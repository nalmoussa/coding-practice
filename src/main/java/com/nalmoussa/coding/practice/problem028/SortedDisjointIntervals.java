package com.nalmoussa.coding.practice.problem028;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SortedDisjointIntervals {
    List<Interval> merge(List<Interval> list1, List<Interval> list2) {
        List<Interval> resultList = new ArrayList<>();
        Iterator<Interval> iterator1 = list1.iterator();
        Iterator<Interval> iterator2 = list2.iterator();
        Interval interval1, interval2, resultInterval;
        boolean readNext1 = true;
        boolean readNext2 = true;
        while (iterator1.hasNext() && iterator2.hasNext()) {
            if (readNext1) {
                interval1 = iterator1.next();
            }
            if (readNext2) {
                interval2 = iterator2.next();
            }
        }

        Iterator<Interval> remainingIterator = (iterator1.hasNext()) ? iterator1 : iterator2;
        while (remainingIterator.hasNext()) {
            resultList.add(remainingIterator.next());
        }
        return resultList;
    }
}

enum IntervalComparisonStatus {

        }

class Interval {
    int first, last;
}
