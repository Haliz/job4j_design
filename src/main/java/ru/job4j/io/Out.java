package ru.job4j.io;

public class Out implements Conditions {

    @Override
    public boolean execute() {
        ConsoleChat.setIsAnswer(false);
        return false;
    }
}
