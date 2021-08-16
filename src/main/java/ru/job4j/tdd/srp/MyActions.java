package ru.job4j.tdd.srp;

import java.io.File;

public interface MyActions {
    void init();

    String read(String path);

    String write(File file, String args);
}
