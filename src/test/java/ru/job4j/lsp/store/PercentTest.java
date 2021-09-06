package ru.job4j.lsp.store;

import org.junit.Test;
import java.time.LocalDate;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PercentTest {

    @Test
    public void whenGetPercent50() {
        LocalDate createDate = LocalDate.of(2020, 12, 10);
        LocalDate expiryDate = LocalDate.of(2021, 12, 10);
        LocalDate currentDate = LocalDate.of(2021, 6, 10);
        assertThat(Percent.getPercent(createDate, expiryDate, currentDate), is(50));
    }
}