package ua.lviv.iot.algo.part1.lab2;

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
}
