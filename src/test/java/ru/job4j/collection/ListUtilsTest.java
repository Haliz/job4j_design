package ru.job4j.collection;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 4));
        ListUtils.addAfter(input, 1, 3);
        assertThat(Arrays.asList(1, 2, 3, 4), Is.is(input));
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        ListUtils.addAfter(input, 2, 4);
        assertThat(Arrays.asList(1, 2, 3, 4), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddAfterWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 4));
        ListUtils.addAfter(input, 3, 2);
    }

    @Test
    public void whenRemoveIfFirst() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        ListUtils.removeIf(input, e -> e.equals(1));
        assertThat(Arrays.asList(2, 3), Is.is(input));
    }

    @Test
    public void whenRemoveIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ListUtils.removeIf(input, e -> e == 3);
        assertThat(Arrays.asList(1, 2, 4), Is.is(input));
    }

    @Test
    public void whenRemoveIfLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 5));
        ListUtils.removeIf(input, e -> e > 2);
        assertThat(Arrays.asList(1, 2), Is.is(input));
    }

    @Test
    public void whenReplaceIfFirst() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        ListUtils.replaceIf(input, x -> x == 1, 10);
        assertThat(Arrays.asList(10, 2, 3), Is.is(input));
    }

    @Test
    public void whenReplaceIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 7, 10));
        ListUtils.replaceIf(input, x -> x > 2 && x < 7, 50);
        assertThat(Arrays.asList(1, 2, 50, 50, 7, 10), Is.is(input));
    }

    @Test
    public void whenReplaceIfLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 7, 10));
        ListUtils.replaceIf(input, x -> x == 10, 50);
        assertThat(Arrays.asList(1, 2, 3, 5, 7, 50), Is.is(input));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 7, 10));
        ListUtils.removeAll(input, Arrays.asList(1, 3, 10));
        assertThat(Arrays.asList(2, 5, 7), Is.is(input));
    }
}
