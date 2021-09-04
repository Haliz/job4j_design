package ru.job4j.lsp.wrong;

public class Example1 {
    public static class Duck {
        public String fly() {
            return "Duck fly!";
        }

        public static void main(String[] args) {
            Duck duck1 = new Duck();
            Duck duck2 = new IronDuck();
            System.out.println(duck1.fly());
            System.out.println(duck2.fly());

        }
    }

    public static class IronDuck extends Duck {
        @Override
        public String fly() {
            return null;   // Не умеет летать возвращает null. Так вообще нельзя делать может всплыть неизвестно где.
        }
    }
}
