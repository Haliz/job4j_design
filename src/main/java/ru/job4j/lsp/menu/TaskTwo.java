package ru.job4j.lsp.menu;

public class TaskTwo implements UserAction {
    @Override
    public String name() {
        return "=== Задача 2. ====";
    }

    @Override
    public boolean execute(Input input, Application application) {
        System.out.println("Выполнена задача 2");
        return true;
    }
}
