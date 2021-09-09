package ru.job4j.lsp.parking;

public interface Parking {

    public boolean checkIn(Vehicles vehicles);

    public boolean checkOut(Vehicles vehicles);
}
