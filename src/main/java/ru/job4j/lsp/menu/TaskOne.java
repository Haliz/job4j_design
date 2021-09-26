package ru.job4j.lsp.menu;

import java.util.ArrayList;
import java.util.List;

public class TaskOne implements UserAction {
    @Override
    public String name() {
        return "=== Задача 1. ====";
    }

    @Override
    public boolean execute(Input input, Application application) {
        List<UserAction> actions = new ArrayList<>();
        actions.add(new TaskOneOne());
        actions.add(new TaskOneTwo());
        actions.add(new ReturnToMainMenu());
        actions.add(new ExitAction());
        application.runMenu(input, actions, application);
        return false;
    }
}
