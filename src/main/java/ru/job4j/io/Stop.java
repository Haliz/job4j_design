package ru.job4j.io;

public class Stop implements Conditions {

    @Override
    public boolean execute() {
        ConsoleChat.setIsAnswer(false);
        return true;
    }
}
