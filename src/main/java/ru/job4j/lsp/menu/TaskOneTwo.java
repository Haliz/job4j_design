package ru.job4j.lsp.menu;

public class TaskOneTwo implements UserAction {
    @Override
    public String name() {
        return "=== Задача 1.2. ====";
    }

    @Override
    public boolean execute(Input input, Application application) {
        System.out.println("Выполнена задача 1.2.");
        return true;
    }
}
