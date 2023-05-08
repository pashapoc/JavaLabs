package ua.lviv.iot;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class MiniRechargeableSaw extends Saw {
    private double batteryCapacity;
    private String batteryType;
    private double batteryConsuming;

    public MiniRechargeableSaw(double batteryCapacity, String BatteryType, double batteryConsuming, String brand, int power, double WorkInHours, boolean isWorking) {
        super(brand, power, WorkInHours, isWorking);
        this.batteryType = batteryType;
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
        return super.getHeaders() + ", " + "batteryCapacity, batteryType, batteryConsuming";
    }

    public String toCSV() {
        return super.toCSV() + ", " + String.format("%s, %s, %s", batteryCapacity, batteryType, batteryConsuming);
    }
}
