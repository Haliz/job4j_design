package ru.job4j.collection.map;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class User {
    String name;
    int children;
    Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("dd MMM yyyy ");
        return "User {"
                + "name = " + name
                + ", children = " + children
                + ", birthday = " + df.format(birthday.getTime())
                + '}';
    }

//    public static void main(String[] args) {
//        Calendar calendar = new GregorianCalendar(1975, 9, 15);
//        User user = new User("Garry", 1, calendar);
//        System.out.println(user);
//    }
}
