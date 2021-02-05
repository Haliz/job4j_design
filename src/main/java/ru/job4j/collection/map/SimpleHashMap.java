package ru.job4j.collection.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMap<K, V> implements Iterable<V> {
    private int capacity = 16;
    private Node<K, V>[] node = new Node[capacity];
    private int size = 0;
    static final float LOAD_FACTOR = 0.75f;
    private int modCount = 0;

    boolean insert(K key, V value) {
        if (node[hash(key)] == null) {
            if (size >= capacity * LOAD_FACTOR) {
                reloadNode();
            }
            node[hash(key)] = new Node<>(key, value);
            size++;
            modCount++;
        }
        return false;
    }

    public V get(K key) {
        if (node[hash(key)] != null && node[hash(key)].getKey().equals(key)) {
            return node[hash(key)].getValue();
        }
        throw new NoSuchElementException();
    }

    public boolean delete(K key) {
        if (node[hash(key)] != null && node[hash(key)].getKey().equals(key)) {
            node[hash(key)] = null;
            size--;
            modCount++;
            return true;
        }
        return false;
    }

    void reloadNode() {
        capacity *= 2;
        Node[] newNode = new Node[capacity];
        for (Node couple : node) {
            newNode[hash((K) couple.getKey())] = couple;
        }
        node = newNode;
    }

    private int hash(K key) {
        return key.hashCode() % capacity;
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            int point = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return point < capacity;
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (node[point] == null) {
                    point++;
                }
                return node[point++].getValue();
            }
        };
    }
}
