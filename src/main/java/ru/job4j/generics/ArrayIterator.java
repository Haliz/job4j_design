package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {
    private final T[] data;
    private int cell;
    private int index = 0;

    public ArrayIterator(T[] data, int cell) {
        this.data = data;
        this.cell = cell;
    }

    @Override
    public boolean hasNext() {
        return index < cell;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[index++];
    }
}
