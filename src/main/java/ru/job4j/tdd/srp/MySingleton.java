package ru.job4j.tdd.srp;

/*Singleton — подразумевает, что помимо своих основных обязанностей класс занимается
 еще и контролированием количества своих экземпляров,
 чем нарушает Single Responsibility Principle.*/

public class MySingleton {
    private static MySingleton instance;

    private MySingleton() {
    }

    public static MySingleton getInstance() {
        if (instance == null) {
            instance = new MySingleton();
        }
        return instance;
    }
}
