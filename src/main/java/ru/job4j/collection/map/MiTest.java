package ru.job4j.collection.map;

public class MiTest {
    public static String binary(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 31; i++) {
            sb.append(num % 2 == 0 ? 0 : 1);
            sb.append((i + 1) % 8 == 0 ? " " : "");
            num /= 2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(binary(1));
        System.out.println(binary(1 << 4));
        System.out.println(Integer.parseInt("00010000", 2));
    }
}
