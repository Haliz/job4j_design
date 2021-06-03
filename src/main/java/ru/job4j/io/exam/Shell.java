package ru.job4j.io.exam;

import java.util.Collections;
import java.util.Stack;

public class Shell {
    private Stack<String> arr = new Stack<>();

    public void cd(String path) {
        if (path.startsWith("/")) {
            arr.clear();
        } else if (path.startsWith("..")) {
            path = path.substring(2);
            if (!arr.isEmpty()) {
                arr.pop();
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

