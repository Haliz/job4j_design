package ru.job4j.collection.map;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class TestingUser {
    public static void main(String[] args) {
        User user1 = new User("Garry", 1, new GregorianCalendar(1975, 9, 15));
        User user2 = new User("Garry", 1, new GregorianCalendar(1975, 9, 15));
        Map<User, Object> map = new HashMap<>();
        map.put(user1, "first");
        map.put(user2, "second");
        System.out.println(map);
    }
}
