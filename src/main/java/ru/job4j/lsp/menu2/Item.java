package ru.job4j.lsp.menu2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Item implements Action {

    private final String name;
    private final Action action;
    private final List<Item> items = new ArrayList<>();

    public Item(String name, Action action) {
        this.name = name;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void add(Item item) {
        items.add(item);
    }

    @Override
    public void act() {
        action.act();
    }

    @Override
    public String toString() {
        return "Item{"
                + "name='" + name + '\''
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
