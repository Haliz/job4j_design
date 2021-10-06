package ru.job4j.lsp.wrong;


public class Example3 {
    public class Rectangle {
        private int a;
        private int b;


        public void setA(int a) {
            this.a = a;
        }

        public void setB(int b) {
            this.b = b;
        }

        public void area() {
            System.out.println(a * b);
        }

        public class Square extends Rectangle {
            private int a;

            @Override
            public void setA(int a) {
                this.a = a;
            }

            @Override
            public void area() {
                System.out.println(Math.sqrt(a));
            }
        }
    }
}
