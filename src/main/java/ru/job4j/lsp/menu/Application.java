package ru.job4j.lsp.menu;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        Application application = new Application();
        application.init(application);
    }

    public void init(Application application) {
        Input input = new ConsoleInput();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new TaskOne());
        actions.add(new TaskTwo());
        actions.add(new ExitAction());
        application.runMenu(input, actions, application);
    }

    public void showMenu(List<UserAction> actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            System.out.println(index + ". " + actions.get(index).name());
        }
    }

    public void runMenu(Input input, List<UserAction> actions, Application application) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.size());
            UserAction action = actions.get(select);
            run = action.execute(input, application);
        }
    }
}
