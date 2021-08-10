package ru.job4j.tdd;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return execute(value, comparator, x -> x > 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return execute(value, comparator, x -> x < 0);
    }

    private <T> T execute(List<T> value, Comparator<T> comparator, Predicate<Integer> predicate) {
        T rsl = value.get(0);
        for (int i = 1; i < value.size(); i++) {
            rsl = predicate.test(comparator.compare(rsl, value.get(i))) ? rsl : value.get(i);
        }
        return rsl;
    }
}
