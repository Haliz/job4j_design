package ru.job4j.lsp.store;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Percent {

    public static int getPercent(LocalDate createDate, LocalDate expiryDate, LocalDate currentDate) {
        if (expiryDate.isAfter(createDate) && !currentDate.isAfter(expiryDate)) {
            long storedDays = ChronoUnit.DAYS.between(createDate, expiryDate);
            long restDays = ChronoUnit.DAYS.between(currentDate, expiryDate);
            int percent = (int) (100 - (restDays * 100 / storedDays));
            return percent;
        } else {
            throw new IllegalArgumentException("Некорректные даты");
        }
    }
}
