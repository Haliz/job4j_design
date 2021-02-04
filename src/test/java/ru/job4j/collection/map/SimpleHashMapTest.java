package ru.job4j.collection.map;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class SimpleHashMapTest {
    private SimpleHashMap<Integer, Integer> map;

    @Before
    public void beforeTest() {
        map = new SimpleHashMap<>();
        map.insert(1, 1);
        map.insert(2, 2);
        map.insert(3, 3);
        map.delete(2);
    }

    @Test
    public void whenInsertTreeElementAndGetTwo() {
        assertThat(map.get(1), is(1));
        assertThat(map.get(3), is(3));
    }

    @Test
    public void whenTestIterator() {
        Iterator iterator = map.iterator();
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(3));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        Iterator iterator = map.iterator();
        map.delete(3);
        iterator.next();
    }
}
