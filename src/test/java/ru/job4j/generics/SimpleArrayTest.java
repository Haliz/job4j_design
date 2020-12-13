package ru.job4j.generics;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SimpleArrayTest {

//    public static void main(String[] args) {
//        SimpleArray<Integer> arr = new SimpleArray<>(7);
//        arr.add(1);
//        arr.add(2);
//        arr.add(3);
//        arr.add(4);
//        System.out.println(arr);
//        arr.remove(1);
//        System.out.println(arr);
//
//        Iterator<Integer> iterator = arr.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//    }

    @Test
    public void whenAddAndGet() {
        SimpleArray<String> arr = new SimpleArray<>(3);
        arr.add("first");
        arr.add("second");
        assertThat(arr.get(0), is("first"));
        assertThat(arr.get(1), is("second"));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void whenGetCheckIndexFalse() {
        SimpleArray<String> arr = new SimpleArray<>(2);
        arr.add("first");
        arr.add("second");
        arr.get(3);
    }

    @Test
    public void whenSet() {
        SimpleArray<String> arr = new SimpleArray<>(2);
        arr.add("first");
        arr.add("second");
        arr.set(0, "third");
        assertThat(arr.get(0), is("third"));
        assertThat(arr.get(1), is("second"));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void whenSetCheckIndexFalse() {
        SimpleArray<String> arr = new SimpleArray<>(2);
        arr.add("first");
        arr.add("second");
        arr.set(3, "third");
    }

    @Test
    public void whenRemove1() {
        SimpleArray<Integer> arr = new SimpleArray<>(4);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.remove(1);
        assertThat(arr.get(0), is(1));
        assertThat(arr.get(1), is(3));
        assertThat(arr.get(2), is(4));
    }
    @Test
    public void whenRemove3() {
        SimpleArray<Integer> arr = new SimpleArray<>(4);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.remove(3);
        assertThat(arr.get(0), is(1));
        assertThat(arr.get(1), is(2));
        assertThat(arr.get(2), is(3));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void whenRemoveCheckIndexFalse() {
        SimpleArray<String> arr = new SimpleArray<>(2);
        arr.add("first");
        arr.add("second");
        arr.remove(-1);
    }

    @Test
    public void whenMultiCallHasNextThenTrue() {
        SimpleArray<Integer> arr = new SimpleArray<>(3);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        Iterator<Integer> iterator = arr.iterator();
        Assert.assertThat(iterator.hasNext(), Matchers.is(true));
        Assert.assertThat(iterator.hasNext(), Matchers.is(true));
    }

    @Test
    public void whenReadSequence() {
        SimpleArray<Integer> arr = new SimpleArray<>(3);
        arr.add(3);
        arr.add(2);
        arr.add(1);
        Iterator<Integer> iterator = arr.iterator();
        Assert.assertThat(iterator.next(), Matchers.is(3));
        Assert.assertThat(iterator.next(), Matchers.is(2));
        Assert.assertThat(iterator.next(), Matchers.is(1));
    }

    @Test (expected = NoSuchElementException.class)
    public void whenNextFromEmpty() {
        SimpleArray<Integer> arr = new SimpleArray<>(3);
        Iterator<Integer> iterator = arr.iterator();
        iterator.next();
    }
}
