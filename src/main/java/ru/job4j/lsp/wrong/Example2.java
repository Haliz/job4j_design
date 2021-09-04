package ru.job4j.lsp.wrong;

public class Example2 {

    public class Security {
        boolean authentic;

        public boolean faceControl() {
            return authentic;
        }
    }

    public class Visitor {
        public void admit(Security security) {
            if (!security.faceControl()) {
                throw new IllegalArgumentException("Go way");
            }
            System.out.println("Welcome");
        }
    }

    public class VIPVisitor extends Visitor {
        @Override
        public void admit(Security security) {
            System.out.println("Welcome"); //Забыли сделать проверку. Возможно не валидное состояние
        }
    }
}
