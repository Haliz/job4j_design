package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.Iterator;

public class ForwardLinkedTest {

    @Test
    public void whenAddThenIter() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
    }

    @Test
    public void whenAddAndRevertThenIter() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        linked.revert();
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(1));
    }

    @Test
    public void whenAddAndRevertThenIter2() {
        ForwardLinked<String> linked = new ForwardLinked<>();
        linked.add("one");
        linked.add("two");
        linked.add("three");
        linked.add("four");
        linked.revert();
        Iterator<String> it = linked.iterator();
        assertThat(it.next(), is("four"));
        assertThat(it.next(), is("three"));
        assertThat(it.next(), is("two"));
        assertThat(it.next(), is("one"));
    }
}
