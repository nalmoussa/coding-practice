package com.nalmoussa.coding.practice.problem002;

import java.util.List;

public class Timeline {
    static final int MIN = 0;
    static final int MAX = 2018;
    TimelineInterval intervalOfHighestPopulation = null;


    Timeline(List<Person> population) {
        buildDisjoinedIntervals(population);
    }

    TimelineInterval getIntervalOfHighestPopulation() {
        return this.intervalOfHighestPopulation;
    }

    private void buildDisjoinedIntervals(List<Person> population) {
        // Set interval of highest population
        population.forEach(this::insert);
    }

    private void insert(Person person) {

    }
}
