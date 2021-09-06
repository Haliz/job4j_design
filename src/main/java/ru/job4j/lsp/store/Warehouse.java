package ru.job4j.lsp.store;

import java.time.LocalDate;

public class Warehouse extends Store {
    @Override
    public void sortByDate(Food food) {
        LocalDate currentDate = LocalDate.now();
        if (!currentDate.isAfter(food.getExpiryDate())) {
            int percent = Percent.getPercent(food.getCreateDate(), food.getExpiryDate(), currentDate);
            if (percent < 25) {
                add(food);
            }
        }
    }
}
