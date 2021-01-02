package ru.job4j.it;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static java.util.Objects.checkIndex;

public class SimpleLinked<E> implements Iterable<E> {
    private Node<E> node;
    private int size = 0;
    private int modCount = 0;

    public void add(E value) {
        modCount++;
        size++;
        Node<E> newNode = new Node<>(value, null);
        if (node == null) {
            node = newNode;
            return;
        }
        Node<E> tail = node;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = newNode;

    }

    public E get(int index) {
        checkIndex(index, size);
        Node<E> current = node;
        for (int i = 1; i <= index; i++) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node<E> itNode = node;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return itNode != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                E value = itNode.value;
                itNode = itNode.next;
                return value;
            }
        };
    }

    private static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }
}
