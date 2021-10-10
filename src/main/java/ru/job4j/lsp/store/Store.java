package ru.job4j.lsp.store;

import java.util.ArrayList;
import java.util.List;

public abstract class Store implements Stores {
    private List<Food> foodList = new ArrayList<>();

    public void add(Food food) {
        foodList.add(food);
    }

    public abstract void sortByDate(Food food);

    public List<Food> getFoodList() {
        return foodList;
    }

    @Override
    public void clear() {
        foodList.clear();
    }
}
