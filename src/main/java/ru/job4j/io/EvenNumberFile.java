package ru.job4j.io;

import java.io.FileInputStream;
import java.util.Scanner;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            Scanner scanner = new Scanner(in);
            while (scanner.hasNext()) {
                int data = scanner.nextInt();
                System.out.print(data);
                if ((data % 2) == 0) {
                    System.out.println(" - четное");
                } else {
                    System.out.println(" - нечетное");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
