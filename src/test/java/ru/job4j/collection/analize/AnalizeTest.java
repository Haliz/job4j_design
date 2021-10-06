package ru.job4j.collection.analize;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
public class AnalizeTest {

    @Test
    public void test() {
        List<User> previous = new ArrayList<>();
        List<User> current = new ArrayList<>();
        previous.add(new User(1, "Igor"));
        previous.add(new User(2, "Tanya"));
        previous.add(new User(3, "Vanya"));
        previous.add(new User(4, "Masha"));
        previous.add(new User(5, "Masha"));
        previous.add(new User(6, "Igor"));
        previous.add(new User(7, "Tanya"));
        previous.add(new User(8, "Nastya"));

        current.add(new User(1, "Egor"));
        current.add(new User(2, "Tanya"));
        current.add(new User(3, "Vanya"));
        current.add(new User(4, "Masha"));
        current.add(new User(5, "Vera"));
        current.add(new User(6, "Egor"));
        current.add(new User(8, "Nastya"));
        current.add(new User(9, "Roma"));
        current.add(new User(10, "Sasha"));

        Analize analize = new Analize();
        assertThat(analize.diff(previous, current).getAdded(), is(2));
        assertThat(analize.diff(previous, current).getChanged(), is(3));
        assertThat(analize.diff(previous, current).getDeleted(), is(1));
    }

    @Test
    public void whenPrevNull() {
        List<User> previous = new ArrayList<>();
        List<User> current = new ArrayList<>();

        current.add(new User(1, "Egor"));
        current.add(new User(2, "Tanya"));
        current.add(new User(3, "Vanya"));

        Analize analize = new Analize();
        assertThat(analize.diff(previous, current).getAdded(), is(3));
        assertThat(analize.diff(previous, current).getChanged(), is(0));
        assertThat(analize.diff(previous, current).getDeleted(), is(0));
    }

    @Test
    public void whenCurrentNull() {
        List<User> previous = new ArrayList<>();
        List<User> current = new ArrayList<>();

        previous.add(new User(1, "Egor"));
        previous.add(new User(2, "Tanya"));
        previous.add(new User(3, "Vanya"));

        Analize analize = new Analize();
        assertThat(analize.diff(previous, current).getAdded(), is(0));
        assertThat(analize.diff(previous, current).getChanged(), is(0));
        assertThat(analize.diff(previous, current).getDeleted(), is(3));
    }
}
