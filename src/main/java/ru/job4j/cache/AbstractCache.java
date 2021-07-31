package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        SoftReference<V> softValue = new SoftReference<>(value);
        cache.put(key, softValue);
    }

    public V get(K key) {
        V result;
        if (!this.cache.containsKey(key) || this.cache.get(key).get() == null) {
            this.put(key, this.load(key));
        }
        result = this.cache.get(key).get();
        return result;
    }

    protected abstract V load(K key);

}
