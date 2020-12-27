package ru.job4j.it;

import ru.job4j.generics.ArrayIterator;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static java.util.Objects.checkIndex;

public class SimpleArray<T> implements Iterable<T> {

    private int size = 0;
    private Object[] container;
    private int modCount = 0;

    public SimpleArray() {
        container = new Object[0];
    }

    public void add(T model) {
        container = Arrays.copyOf(container, ++size);
        container[size - 1] = model;
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
