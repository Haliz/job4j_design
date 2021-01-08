package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> del = head;
        head = head.next;
        return del.value;
    }

    public T deleteLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> tail = head;
        Node<T> beforeLast = head;
        while (tail.next != null) {
            beforeLast = tail;
            tail = tail.next;
        }
        if (tail == head) {
            head = null;
            return tail.value;
        }
        beforeLast.next = null;
        return tail.value;
    }

    public void revert() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        if (head.next != null) {
            Node<T> tail = head.next;
            Node<T> beforeLast = head;
            Node<T> previous = null;
            while (tail.next != null) {
                beforeLast.next = previous;
                previous = beforeLast;
                beforeLast = tail;
                tail = tail.next;
            }
            beforeLast.next = previous;
            tail.next = beforeLast;
            head = tail;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
