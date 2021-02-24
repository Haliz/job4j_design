package ru.job4j.collection.mail;


import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CheckMailTest {
    public static Map<String, TreeSet<String>> sortMap(Map<String, Set<String>> input) {
        Map<String, TreeSet<String>> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Set<String>> item : input.entrySet()) {
            sortedMap.put(item.getKey(), new TreeSet<>(item.getValue()));
        }
        return sortedMap;
    }

    @Test
    public void whenMerge() {
        Map<String, Set<String>> inMap = new LinkedHashMap<>();
        inMap.put("user1", Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru"));
        inMap.put("user2", Set.of("foo@gmail.com", "ups@pisem.net"));
        inMap.put("user3", Set.of("xyz@pisem.net", "vasya@pupkin.com"));
        inMap.put("user4", Set.of("ups@pisem.net", "aaa@bbb.ru"));
        inMap.put("user5", Set.of("xyz@pisem.net"));

        Map<String, Set<String>> expMap = new LinkedHashMap<>();
        expMap.put("user1", Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru", "ups@pisem.net", "aaa@bbb.ru"));
        expMap.put("user3", Set.of("xyz@pisem.net", "vasya@pupkin.com"));

        assertThat(sortMap(CheckMail.merge(inMap)).toString(), is(sortMap(expMap).toString()));
    }

    @Test
    public void whenAllSame() {
        Map<String, Set<String>> inMap = new LinkedHashMap<>();
        inMap.put("user1", Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru"));
        inMap.put("user2", Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru"));
        inMap.put("user3", Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru"));

        Map<String, Set<String>> expMap = new LinkedHashMap<>();
        expMap.put("user1", Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru"));

        assertThat(sortMap(CheckMail.merge(inMap)).toString(), is(sortMap(expMap).toString()));
    }

    @Test
    public void whenAllDifferent() {
        Map<String, Set<String>> inMap = new LinkedHashMap<>();
        inMap.put("user1", Set.of("xxx@ya.ru"));
        inMap.put("user2", Set.of("foo@gmail.com"));
        inMap.put("user3", Set.of("lol@mail.ru"));

        Map<String, Set<String>> expMap = new LinkedHashMap<>();
        expMap.put("user1", Set.of("xxx@ya.ru"));
        expMap.put("user2", Set.of("foo@gmail.com"));
        expMap.put("user3", Set.of("lol@mail.ru"));

        assertThat(sortMap(CheckMail.merge(inMap)).toString(), is(sortMap(expMap).toString()));
    }
}
