package ru.job4j.tdd.srp;

import java.util.function.Predicate;

public interface Report {
    String generate(Predicate<Employee> filter);
}
