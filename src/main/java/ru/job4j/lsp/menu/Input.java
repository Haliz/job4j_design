package ru.job4j.lsp.menu;

public interface Input {
    String askStr(String question);

    int askInt(String question);

    int askInt(String question, int max);
}
