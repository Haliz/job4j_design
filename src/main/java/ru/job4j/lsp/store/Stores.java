package ru.job4j.lsp.store;

import java.util.List;

public interface Stores {

    public void sortByDate(Food food);

    public List<Food> getFoodList();

    public void clear();
}
