package ru.job4j.lsp.menu2;

import ru.job4j.lsp.menu.ConsoleInput;
import ru.job4j.lsp.menu.Input;
import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<Item> list = new ArrayList<>();

    public void add(String parentName, Item child) {
        if (parentName.equals("Menu")) {
            list.add(child);
        } else {
            add(parentName, child, this.list);
        }
    }

    public void add(String parentName, Item child, List<Item> list) {
        for (Item item : list) {
            if (item.getName().contains(parentName)) {
                item.add(child);
            } else {
                add(parentName, child, item.getItems());
            }
        }
    }

//    public Item get(String name) throws Exception {
//        for (Item item : list) {
//            if (item.getName().equals(name)) {
//                return item;
//            } else {
//                return get(name, item.getItems());
//            }
//        }
//        throw new Exception("Задача не найдена");
//    }

    private Item get(String name, List<Item> list) {
        List<Item> child = new ArrayList<>();
        for (Item item : list) {
            if (item.getName().equals(name)) {
                return item;
            }
            if (!item.getItems().isEmpty()) {
                child.addAll(item.getItems());
            }
        }
        if (!child.isEmpty()) {
            return get(name, child);
        } else {
            throw new IllegalArgumentException("Задача не найдена");
        }
    }

    public List<Item> getList() {
        return list;
    }

    public void print() {
        for (Item item : list) {
            print(item);
        }
    }

    private void print(Item item) {
        System.out.println(item.getName());
        for (Item itemChild : item.getItems()) {
            print(itemChild);
        }
    }

    public String printToString() {
        StringBuilder sb = new StringBuilder();
        for (Item item : list) {
            if (list != null) {
                sb.append(item.getName()).append(System.lineSeparator());
                sb.append(printToString(item));
            }
        }
        return "Menu{"
                + System.lineSeparator()
                + sb.toString()
                + '}';
    }

    private String printToString(Item item) {
        StringBuilder sb = new StringBuilder();
        for (Item itemChild : item.getItems()) {
            if (itemChild.getItems() != null) {
                sb.append(itemChild.getName()).append(System.lineSeparator());
                sb.append(printToString(itemChild));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        Menu menu = new Menu();
        menu.add("Menu", new Item("Задача 1.", new SomeAction()));
        menu.add("Задача 1.", new Item("--Задача 1.1.", new SomeAction()));
        menu.add("Задача 1.", new Item("--Задача 1.2.", new SomeAction()));
        menu.add("--Задача 1.1.", new Item("----Задача 1.1.1.", new SomeAction()));
        menu.add("--Задача 1.1.", new Item("----Задача 1.1.2.", new SomeAction()));
        menu.print();
        Input input = new ConsoleInput();
        String select = input.askStr("Select: ");
        menu.get(select, menu.list).act();
    }
}
