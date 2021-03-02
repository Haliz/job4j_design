package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            int[] mas = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            for (int i : mas) {
                for (int j : mas) {
                    int res = i * j;
                    out.write(Integer.toString(res).getBytes());
                    out.write('\t'); // то же самое что и out.write("\t".getBytes());
                }
                out.write('\n');
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
