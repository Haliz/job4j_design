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
        V value = cache.getOrDefault(key, new SoftReference<>(null)).get(); // Здесь создаю жесткую ссылку
        if (!this.cache.containsKey(key) || value == null) {
            result = load(key);
            put(key, result);
        } else {
            result = value; // Результат по жесткой ссылке
        }
        return result;
    }

    protected abstract V load(K key);

}
