package ru.job4j.lsp.parking;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Ignore;
import org.junit.Test;

@Ignore
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
    public void checkParkingController() {
        Parking parking = new CarParking(1, 1);
        ParkingController controller = new ParkingController(parking);
        Vehicles car = new PassengerCar();
        Vehicles truck = new Truck(2);
        controller.toParking(car);
        controller.toParking(truck);
        CarParking expParking = (CarParking) parking;
        assertThat(expParking.getOccupiedCarSpaces(), is(1));
        assertThat(expParking.getOccupiedTruckSpaces(), is(1));
    }

    @Test
    public void when3CarsTo2CarPlaceAnd1TruckPlace() {
        Parking parking = new CarParking(2, 1);
        ParkingController controller = new ParkingController(parking);
        Vehicles car = new PassengerCar();
        controller.toParking(car);
        controller.toParking(car);
        controller.toParking(car);
        CarParking expParking = (CarParking) parking;
        assertThat(expParking.getOccupiedCarSpaces(), is(2));
    }

    @Test
    public void whenTruckToCarPlases() {
        Parking parking = new CarParking(6, 0);
        ParkingController controller = new ParkingController(parking);
        Vehicles car = new PassengerCar();
        Vehicles truck = new Truck(3);
        controller.toParking(car);
        controller.toParking(car);
        controller.toParking(truck);
        CarParking expParking = (CarParking) parking;
        assertThat(expParking.getOccupiedCarSpaces(), is(5));

    }

    @Test
    public void whenTruckNoPlacedOnTruckPlaces() {
        Parking parking = new CarParking(6, 1);
        ParkingController controller = new ParkingController(parking);
        Vehicles car = new PassengerCar();
        Vehicles truck1 = new Truck(3);
        Vehicles truck2 = new Truck(2);
        controller.toParking(car);
        controller.toParking(car);
        controller.toParking(truck1);
        controller.toParking(truck2);
        CarParking expParking = (CarParking) parking;
        assertThat(expParking.getOccupiedCarSpaces(), is(4));
        assertThat(expParking.getOccupiedTruckSpaces(), is(1));
    }
}