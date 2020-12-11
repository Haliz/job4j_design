package ru.job4j.generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static java.util.Objects.checkIndex;

public class SimpleArray<T> implements Iterable<T> {

    private T[] data;
    private final int arrCells;
    private int index = -1;

    public SimpleArray(int arrCells) {
        data = (T[]) new Object[arrCells];
        this.arrCells = arrCells;
    }

    public T get(int index) {
        checkIndex(index, arrCells);
        return data[index];
    }

    public void set(int index, T model) {
        checkIndex(index, arrCells);
        data[index] = model;
    }

    public boolean add(T model) {
        if (arrCells > 0 && index < arrCells) {
            index++;
            data[index] = model;
            return true;
        }
    return false;
    }

    public void remove(int index) {
        checkIndex(index, arrCells);
        while (index < this.index) {
            data[index] = data[index + 1];
            index++;
        }
        data[this.index] = null;
        this.index--;

    }

    @Override
    public Iterator<T> iterator() {
       return new ArrayIterator<>(this.data);
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
