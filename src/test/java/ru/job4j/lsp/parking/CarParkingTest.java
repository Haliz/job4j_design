package ru.job4j.lsp.parking;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Ignore;
import org.junit.Test;


public class CarParkingTest {

    @Test
    public void checkParking() {
        Parking parking = new CarParking(1, 1);
        Vehicles car = new PassengerCar();
        Vehicles truck = new Truck(2);
        assertThat(parking.parking(car), is(true));
        assertThat(parking.parking(truck), is(true));
    }

    @Test
    public void checkNoParking() {
        Parking parking = new CarParking(0, 0);
        Vehicles car = new PassengerCar();
        Vehicles truck = new Truck(2);
        assertThat(parking.parking(car), is(false));
        assertThat(parking.parking(truck), is(false));
    }


    @Test
    public void when3CarsTo2CarPlaceAnd1TruckPlace() {
        Parking parking = new CarParking(2, 1);
        Vehicles car = new PassengerCar();
        assertThat(parking.parking(car), is(true));
        assertThat(parking.parking(car), is(true));
        assertThat(parking.parking(car), is(false));
    }

    @Test
    public void whenTruckToCarPlases() {
        Parking parking = new CarParking(5, 0);
        Vehicles car = new PassengerCar();
        Vehicles truck = new Truck(3);
        assertThat(parking.parking(car), is(true));
        assertThat(parking.parking(car), is(true));
        assertThat(parking.parking(truck), is(true));
        assertThat(parking.parking(car), is(false));
        assertThat(parking.parking(truck), is(false));

    }

    @Test
    public void whenTruckNoPlacedOnTruckPlaces() {
        Parking parking = new CarParking(6, 1);
        Vehicles truck1 = new Truck(3);
        Vehicles truck2 = new Truck(2);
        assertThat(parking.parking(truck1), is(true));
        assertThat(parking.parking(truck2), is(true));
        assertThat(parking.parking(truck2), is(true));
        assertThat(parking.parking(truck1), is(false));
        assertThat(parking.parking(truck2), is(true));
    }
}