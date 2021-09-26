package ru.job4j.lsp.menu;

public interface UserAction {
    String name();

    boolean execute(Input input, Application application);
}
