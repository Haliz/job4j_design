package ru.job4j.generics;

import java.util.Arrays;
import java.util.Iterator;

import static java.util.Objects.checkIndex;

public class SimpleArray<T> implements Iterable<T> {

    private final T[] data;
    private int cell = 0;

    public SimpleArray(int arrCells) {
        data = (T[]) new Object[arrCells];
    }

    public T get(int index) {
        checkIndex(index, cell);
        return data[index];
    }

    public void set(int index, T model) {
        checkIndex(index, cell);
        data[index] = model;
    }

    public boolean add(T model) {
        if (data.length > 0 && cell < data.length) {
            data[cell] = model;
            cell++;
            return true;
        }
    return false;
    }

    public void remove(int index) {
        checkIndex(index, cell);
            System.arraycopy(data, index + 1, data, index, cell - (index + 1));
        data[cell - 1] = null;
    }

    @Override
    public Iterator<T> iterator() {
       return new ArrayIterator<>(this.data, cell);
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
