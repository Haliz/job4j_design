package ru.job4j.lsp.menu;

public class ReturnToMainMenu implements UserAction {
    @Override
    public String name() {
        return "=== Вернуться в главное меню ====";
    }

    @Override
    public boolean execute(Input input, Application application) {
        application.init(application);
        return false;
    }
}
