package ua.lviv.iot;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class ElectricSaw extends Saw {
    private String electricEngineType;
    private double batteryCapacity;
    private double batteryConsuming;

    public ElectricSaw(String electricEngineType, double batteryCapacity, double batteryConsuming, String brand, int power, double workInHours, boolean isWorking) {
        super(brand, power, workInHours, isWorking);
        this.electricEngineType = electricEngineType;
        this.batteryCapacity = batteryCapacity;
        this.batteryConsuming = batteryConsuming;
    }

    public double getRemainingWorkTime() {
        if (super.isWorking()) {
            return batteryConsuming / batteryCapacity;
        } else {
            return 0;
        }
    }

    public String getHeaders() {
        return super.getHeaders() + ", " + "electricEngineType, batteryCapacity, batteryConsuming";
    }

    public String toCSV() {
        return super.toCSV() + ", " + String.format("%s, %s, %s", electricEngineType, batteryCapacity, batteryConsuming);
    }
}
