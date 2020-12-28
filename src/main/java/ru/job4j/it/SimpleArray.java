package ru.job4j.it;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static java.util.Objects.checkIndex;

public class SimpleArray<T> implements Iterable<T> {

    private int capacity = 2;
    private int size = 0;
    private Object[] container;
    private int modCount = 0;

    public SimpleArray() {
        container = new Object[capacity];
    }

    public void add(T model) {
        if (size == capacity) {
            capacity = size * 2;
            container = Arrays.copyOf(container, capacity);
        }
        container[size++] = model;
        modCount++;
    }

    public T get(int index) {
        checkIndex(index, size);
        return (T) container[index];
    }


    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>();
    }

    private class ArrayIterator<T> implements Iterator<T> {

        private final int expectedModCount = modCount;
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return (T) container[index++];
        }
    }
}
