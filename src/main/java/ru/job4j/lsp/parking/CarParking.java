package ru.job4j.lsp.parking;

public class CarParking implements Parking {


    @Override
    public boolean checkIn(Vehicles vehicles) {
        return false;
    }

    @Override
    public boolean checkOut(Vehicles vehicles) {
        return false;
    }

}
