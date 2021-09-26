package ru.job4j.lsp.menu;

public class ExitAction implements UserAction {
    @Override
    public String name() {
        return "=== Завершить программу ====";
    }

    @Override
    public boolean execute(Input input, Application application) {
        return false;
    }
}
