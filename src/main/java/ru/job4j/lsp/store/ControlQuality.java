package ru.job4j.lsp.store;


import java.util.ArrayList;
import java.util.List;

public class ControlQuality {
    private final List<Stores> storesList;

    public ControlQuality(List<Stores> storesList) {
        this.storesList = storesList;
    }

    public void toStore(Food food) {
        for (Stores stores : storesList) {
            stores.sortByDate(food);
        }
    }

    public void toStore(List<Food> foods) {
        for (Food food : foods) {
            toStore(food);
        }
    }

    public void resort() {
        List<Food> foodList = new ArrayList<>();
        for (Stores store : storesList) {
            foodList.addAll(store.getFoodList());
            store.clear();
        }
        toStore(foodList);
    }
}
