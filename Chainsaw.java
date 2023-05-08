package ua.lviv.iot;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Chainsaw extends Saw {
    private double fuelTankCapacity;
    private double fuelLevel;
    private double fuelConsumption;

    public Chainsaw(double fuelTankCapacity, double fuelLevel, double fuelConsumption, String brand, int power, double workInHours, boolean isWorking) {
        super(brand, power, workInHours, isWorking);
        this.fuelTankCapacity = fuelTankCapacity;
        this.fuelLevel = fuelLevel;
        this.fuelConsumption = fuelConsumption;
    }

    public double getRemainingWorkTime() {
        if (super.isWorking()) {
            return (fuelLevel / fuelConsumption);
        } else {
            return 0;
        }
    }

    public String getHeaders() {
        return super.getHeaders() + ", " + "fuelTankCapacity, fuelLevel, fuelConsumption";
    }

    public String toCSV() {
        return super.toCSV() + ", " + String.format("%s, %s, %s", fuelTankCapacity, fuelLevel, fuelConsumption);
    }
}