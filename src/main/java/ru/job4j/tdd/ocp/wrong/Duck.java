package ru.job4j.tdd.ocp.wrong;

public class Duck {
    public void fly() {
        System.out.println("Duck fly");
    }
    public void quack() {
        System.out.println("Duck quack");
    }
/*
    Возникнут проблемы пры добавлении резиновой утки которая не крякает и не летает,
    а например стоит возле компьютера, или манок (он вообще не утка, но крякает).
*/
}
