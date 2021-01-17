package ru.job4j.collection;

import ru.job4j.it.SimpleArray;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Iterable<T> {
    private final SimpleArray<T> simpleArray = new SimpleArray<>();

    public void add(T model) {
        if (!contains(model)) {
            simpleArray.add(model);
        }
    }

    public boolean contains(T value) {
        for (Object i : simpleArray) {
            if (Objects.equals(value, i)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return simpleArray.iterator();
    }
}

