package ru.job4j.collection.map;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMap<K, V> implements Iterable<V> {
    private int capacity = 16;
    private Node<K, V>[] node = new Node[capacity];
    private int size = 0;
    static final float LOAD_FACTOR = 0.75f;

    boolean insert(K key, V value) {
        int index = hash(key);
        if (node[index] == null) {
            if (size >= capacity * LOAD_FACTOR) {
                reloadNode();
            }
            node[index] = new Node<>(key, value);
            size++;
        }
        return false;
    }

    public V get(K key) {
        return node[hash(key)].getValue();
    }

    public boolean delete(K key) {
        if (node[hash(key)] != null) {
            node[hash(key)] = null;
        size--;
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

            @Override
            public boolean hasNext() {
                return point < capacity;
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                while (node[point] == null) {
                    point++;
                }
                return node[point++].getValue();
            }
        };
    }
}
