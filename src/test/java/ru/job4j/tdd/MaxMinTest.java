package ru.job4j.tdd;


import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Comparator;
import java.util.List;


public class MaxMinTest {

    @Test
    public void whenMax() {
        MaxMin maxMin = new MaxMin();
        Comparator<Integer> comparator = Integer::compareTo;
        var max = maxMin.max(List.of(1, 5, 2, 7, 4), comparator);
        assertThat(max, is(7));
    }

    @Test
    public void whenMin() {
        MaxMin maxMin = new MaxMin();
        Comparator<Integer> comparator = Integer::compareTo;
        var min = maxMin.min(List.of(1, 5, 2, 7, 4), comparator);
        assertThat(min, is(1));
    }
}