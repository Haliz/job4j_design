package ru.job4j.collection;

import ru.job4j.it.SimpleArray;
import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {
    private final SimpleArray<T> simpleArray = new SimpleArray<>();

    public void add(T model) {
        Object[] container = simpleArray.getContainer();
        for (Object i : container) {
            if (model.equals(i)) {
                return;
            }
        }
        simpleArray.add(model);
    }

    @Override
    public Iterator<T> iterator() {
        return simpleArray.iterator();
    }
}

