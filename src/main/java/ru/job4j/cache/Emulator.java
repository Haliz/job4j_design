package ru.job4j.cache;

import java.util.Scanner;

public class Emulator {
    public static void main(String[] args) {
        AbstractCache<String, String> cache = null;
        boolean repeat = true;
        while (repeat) {
            System.out.print("\n===MENU===\n"
                    + "1. Выбор папки\n"
                    + "2. Выбор файла\n"
                    + "3. Выход\n"
                    + "Select: ");
            Scanner scanner = new Scanner(System.in);
            String sel = scanner.nextLine();
            if (sel.equals("3")) {
                repeat = false;
            } else if (sel.equals("1")) {
                System.out.print("Введите путь папки: ");
                String path = scanner.nextLine();
                cache = new DirFileCache(path);
            } else if (sel.equals("2")) {
                if (cache == null) {
                    System.out.println("Папка не определена, необходимо выбрать папку.");
                } else {
                    System.out.print("Введите имя файла: ");
                    String name = scanner.nextLine();
                    System.out.println(cache.get(name));
                }
            }
        }
    }
}
