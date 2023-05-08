package ua.lviv.iot;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class ReciprocatingSaw extends Saw {
    private double batteryCapacity;
    private String specialFeature;
    private double batteryConsuming;

    public ReciprocatingSaw(double batteryCapacity, String specialFeature, double batteryConsuming, String brand, int power, double workInHours, boolean isWorking) {
        super(brand, power, workInHours, isWorking);
        this.specialFeature = specialFeature;
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
        return super.getHeaders() + ", " + "batteryCapacity, specialFeature, batteryConsuming";
    }

    public String toCSV() {
        return super.toCSV() + ", " + String.format("%s, %s, %s", batteryCapacity, specialFeature, batteryConsuming);
    }
}
