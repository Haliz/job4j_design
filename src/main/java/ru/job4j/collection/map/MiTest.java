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
        Integer h = 50;
        h.hashCode();
        Integer h2 = h >>> 16;
        int r = (h.hashCode()) ^ (h >>> 16);
        System.out.println(binary(h));
        System.out.println(binary(h.hashCode()));
        System.out.println(binary(h2));
        System.out.println(binary(r));
        System.out.println(r);





    }
}
