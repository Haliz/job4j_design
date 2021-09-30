package ru.job4j.lsp.menu2;

public interface Input {
    String askStr(String question);

    int askInt(String question);

    int askInt(String question, int max);
}
