package ru.job4j.io;

public class Continue implements Conditions {
    @Override
    public boolean execute() {
        ConsoleChat.setIsAnswer(true);
        return true;
    }
}
