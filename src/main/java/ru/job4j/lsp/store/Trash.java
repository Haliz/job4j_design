package ru.job4j.lsp.store;

import java.time.LocalDate;

public class Trash extends Store {
    @Override
    public void sortByDate(Food food) {
        LocalDate currentDate = LocalDate.now();
        if (currentDate.isAfter(food.getExpiryDate())) {
            add(food);
        }
    }
}
