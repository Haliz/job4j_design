package ru.job4j.tdd.ocp.wrong;

public class AllTerrainVehicle {
    private int numberOfWheels;

    public void go() {
        System.out.println("Go to the marsh.");
    }
}
/*Здесь при наследовании может возникнуть промлема,
поле numberOfWheels, может быть не актуально для наследников,
поскольку существуют вездеходы на гусеничном ходу или на воздушной подушке.*/
