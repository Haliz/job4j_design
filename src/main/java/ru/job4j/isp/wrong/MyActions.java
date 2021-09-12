package ru.job4j.isp.wrong;

import java.io.File;

public interface MyActions {
    void init();

    String read(String path);

    String write(File file, String args);
}
