package ru.job4j.lsp.store;

import java.time.LocalDate;

public class Shop extends Store {
    @Override
    public void sortByDate(Food food) {
        LocalDate currentDate = LocalDate.now();
        if (!currentDate.isAfter(food.getExpiryDate())) {
            int percent = Percent.getPercent(food.getCreateDate(), food.getExpiryDate(), currentDate);
            if (percent >= 25) {
                if (percent > 75) {
                    food.setDiscount(food.getPrice() * 0.2);
                }
                add(food);
            }
        }
    }
}
