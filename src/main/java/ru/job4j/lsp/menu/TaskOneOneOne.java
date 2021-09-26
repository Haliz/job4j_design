package ru.job4j.lsp.menu;

public class TaskOneOneOne implements UserAction {
    @Override
    public String name() {
        return "=== Задача 1.1.1. ====";
    }

    @Override
    public boolean execute(Input input, Application application) {
        System.out.println("Выполнена задача 1.1.1");
        return true;
    }
}
