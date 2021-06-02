package ru.job4j.io.exam;

import java.util.ArrayList;
import java.util.Collections;

public class Shell {
    private ArrayList<String> arr = new ArrayList<>();

    public void cd(String path) {
        if (path.startsWith("/")) {
            arr.clear();
        } else if (path.startsWith("..")) {
            path = path.substring(2);
            if (!arr.isEmpty()) {
                arr.remove((arr.size()) - 1);
            }
        }
        String[] split = path.split("/");
        Collections.addAll(arr, split);
        arr.remove("");
    }

    public String pwd() {
        String rsl = "/";
        if (!arr.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (String value : arr) {
                sb.append("/").append(value);
            }
            rsl = sb.toString();
        }
        return rsl;
    }
}

