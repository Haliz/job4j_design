package ru.job4j.lsp.store;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ControlQualityTest {
    private List<Stores> storesList;
    LocalDate currentDate;
    ControlQuality controlQuality;
    Warehouse warehouse;
    Shop shop;
    Trash trash;

    @Before
    public void initObjects() {
        warehouse = new Warehouse();
        shop = new Shop();
        trash = new Trash();
        storesList = List.of(warehouse, shop, trash);
        controlQuality = new ControlQuality(storesList);
        currentDate = LocalDate.now();
    }

    @Test
    public void whenToWarehouse() {
        LocalDate createDate = currentDate.minusDays(1);
        LocalDate expiryDate = createDate.plusYears(1);
        Food food = new Food("Продукт", createDate, expiryDate, 100);
        controlQuality.toStore(food);
        List<Food> exp = List.of(food);

        assertThat(warehouse.getFoodList(), is(exp));
    }

    @Test
    public void whenToShop() {
        LocalDate createDate1 = currentDate.minusMonths(6);
        LocalDate expiryDate1 = createDate1.plusYears(1);
        LocalDate createDate2 = currentDate.minusMonths(1);
        LocalDate expiryDate2 = currentDate.plusDays(1);
        Food food1 = new Food("Продукт1", createDate1, expiryDate1, 100);
        Food food2 = new Food("Продукт2", createDate2, expiryDate2, 100);
        Food discountFood = new Food("Продукт2", createDate2, expiryDate2, 100);
        discountFood.setDiscount(20);
        controlQuality.toStore(food1);
        controlQuality.toStore(food2);
        List<Food> exp = List.of(food1, discountFood);

        assertThat(shop.getFoodList(), is(exp));
    }

    @Test
    public void whenToTrash() {
        LocalDate createDate = currentDate.minusMonths(1);
        LocalDate expiryDate = createDate.minusDays(1);
        Food food = new Food("Продукт", createDate, expiryDate, 100);
        controlQuality.toStore(food);
        List<Food> exp = List.of(food);

        assertThat(trash.getFoodList(), is(exp));
    }
}