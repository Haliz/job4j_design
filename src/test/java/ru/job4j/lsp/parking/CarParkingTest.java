package ru.job4j.lsp.parking;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Ignore;
import org.junit.Test;

public class CarParkingTest {

    @Test
    @Ignore
    public void checkParking() {
        Parking parking = new CarParking(1, 1);
        PassengerCar car = new PassengerCar();
        Truck truck = new Truck(2);
        assertThat(parking.parking(car), is(true));
        assertThat(parking.parking(truck), is(true));
    }

    @Test
    @Ignore
    public void checkNoParking() {
        Parking parking = new CarParking(0, 0);
        PassengerCar car = new PassengerCar();
        Truck truck = new Truck(2);
        assertThat(parking.parking(car), is(false));
        assertThat(parking.parking(truck), is(false));
    }

    @Test
    @Ignore
    public void checkParkingController() {
        CarParking parking = new CarParking(1, 1);
        ParkingController controller = new ParkingController(parking);
        PassengerCar car = new PassengerCar();
        Truck truck = new Truck(2);
        controller.toParking(car);
        controller.toParking(truck);
        assertThat(parking.getOccupiedCarSpaces(), is(1));
        assertThat(parking.getOccupiedTruckSpaces(), is(1));
    }

    @Test
    @Ignore
    public void when3CarsTo2CarPlaceAnd1TruckPlace() {
        CarParking parking = new CarParking(2, 1);
        ParkingController controller = new ParkingController(parking);
        PassengerCar car = new PassengerCar();
        controller.toParking(car);
        controller.toParking(car);
        controller.toParking(car);
        assertThat(parking.getOccupiedCarSpaces(), is(2));
    }

    @Test
    @Ignore
    public void whenTruckToCarPlases() {
        CarParking parking = new CarParking(6, 0);
        ParkingController controller = new ParkingController(parking);
        PassengerCar car = new PassengerCar();
        Truck truck = new Truck(3);
        controller.toParking(car);
        controller.toParking(car);
        controller.toParking(truck);
        assertThat(parking.getOccupiedCarSpaces(), is(5));

    }

    @Test
    @Ignore
    public void whenTruckNoPlacedOnTruckPlaces() {
        CarParking parking = new CarParking(6, 1);
        ParkingController controller = new ParkingController(parking);
        PassengerCar car = new PassengerCar();
        Truck truck1 = new Truck(3);
        Truck truck2 = new Truck(2);
        controller.toParking(car);
        controller.toParking(car);
        controller.toParking(truck1);
        controller.toParking(truck2);
        assertThat(parking.getOccupiedCarSpaces(), is(4));
        assertThat(parking.getOccupiedTruckSpaces(), is(1));
    }
}