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
        LocalDate expiryDate = currentDate.minusDays(1);
        Food food = new Food("Продукт", createDate, expiryDate, 100);
        controlQuality.toStore(food);
        List<Food> exp = List.of(food);

        assertThat(trash.getFoodList(), is(exp));
    }

    @Test
    public void whenManyFoodsToDifferentStores() {
        LocalDate createDate1 = currentDate.minusDays(1);
        LocalDate expiryDate1 = createDate1.plusYears(1);
        Food freshFood = new Food("На склад", createDate1, expiryDate1, 100);
        LocalDate createDate2 = currentDate.minusMonths(6);
        LocalDate expiryDate2 = createDate2.plusYears(1);
        Food shopFood1 = new Food("В магазин без скидки", createDate2, expiryDate2, 100);
        LocalDate createDate3 = currentDate.minusMonths(1);
        LocalDate expiryDate3 = currentDate.plusDays(1);
        Food shopFood2 = new Food("В магазин со скидкой", createDate3, expiryDate3, 100);
        LocalDate createDate4 = currentDate.minusMonths(1);
        LocalDate expiryDate4 = currentDate.minusDays(1);
        Food trashFood = new Food("На помойку", createDate4, expiryDate4, 100);
        List<Food> foodList = List.of(freshFood, shopFood1, shopFood2, trashFood);

        List<Food> expWarehouse = List.of(new Food("На склад", createDate1, expiryDate1, 100));
        shopFood2.setDiscount(20);
        List<Food> expShop = List.of(new Food("В магазин без скидки", createDate2, expiryDate2, 100),
                shopFood2);
        List<Food> expTrash = List.of(new Food("На помойку", createDate4, expiryDate4, 100));

        controlQuality.toStore(foodList);

        assertThat(trash.getFoodList(), is(expTrash));
        assertThat(warehouse.getFoodList(), is(expWarehouse));
        assertThat(shop.getFoodList(), is(expShop));
    }
}