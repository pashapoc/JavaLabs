package ua.lviv.iot;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class Saw {
    private String brand;
    private int power;
    private double workInHours;
    private boolean isWorking;

    public abstract double getRemainingWorkTime();

    public String getHeaders() {
        String header = "brand, power, workInHours, isWorking";
        return header;
    }

    public String toCSV() {
        return String.format("%s, %s, %s, %s", brand, power, workInHours, isWorking);
    }
}
